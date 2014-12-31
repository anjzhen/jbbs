package cc.ymee.common.spring.controller;

import com.alibaba.fastjson.JSON;
import com.octo.captcha.service.CaptchaServiceException;
import cc.ymee.third.jcaptcha.CaptchaServiceSingleton;
import cc.ymee.third.json.Result;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @author :Anjero
 * @version :1.0
 * @Title :BaseController.java
 * @Description:
 * @Datetime :2013-8-29
 * @Copyright :Copyright (c) 2012
 *
 */
public class BaseController implements Serializable {


    public static final String REDIRECT = "redirect:";
    private static final long serialVersionUID = 7544640703613411536L;


    /**
     * 控制器LOG*/
    protected Logger LOG = Logger.getLogger("controller");

    /**
     * 用户session
     */

    public static final String SESSION_ADMIN = "session_admin";


    public static final String SESSEION_USER = "sesseion_user";

    public static final String WECHAT_USER_SESSION = "wechat_user_session";


    public static final String SESSEION_PRO = "sesseion_province";


    protected String success(Object obj) {
        Result result = new Result();
        result.setCode(200);
        result.setResult(obj);
        result.setDescription("succuss");
        try {
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    protected String redirect(String location) {
        return REDIRECT + location;
    }

    protected String success() {
        return success(null);
    }

    protected Map<String, String> error() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("code", "201");
        return map;
    }

    protected String error(String message) {
        Result result = new Result();
        result.setCode(201);
        result.setResult(message);
        result.setDescription("error");
        try {
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void addAlertMessage(Model model, String msg) {
        model.addAttribute("msg", msg);

    }

    protected HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 用于验证验证码(取于JCaptcha，当一次验证不通过时，将会清空sesseion。)
     *
     * @param value
     * @return boolean 当不存在，过期，错误 时，都将返回false.
     */
    protected boolean validateCaptcha(String value) {
        Boolean bool = Boolean.FALSE;
        try {
            bool = CaptchaServiceSingleton.getInstance().validateResponseForID(getRequest().getSession().getId(), value);
        } catch (CaptchaServiceException e) {
            LOG.debug("captcha error.");
        }
        return bool;
    }
}
