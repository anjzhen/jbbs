package cc.ymee.third.jcaptcha;


import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import org.apache.log4j.Logger;

/**
 * 验证码
 * @author :anjero
 * @version :1.0
 * @Title :CaptchaServiceSingleton.java
 * @Description:
 * @Datetime : 2014-5-23 上午10:42
 * @Copyright :Copyright (c) 2012
 *
 */

public class CaptchaServiceSingleton {

    Logger LOG = Logger.getLogger("Captcha");

    private static GenericManageableCaptchaService instance ;


    public void setInstance(GenericManageableCaptchaService instance) {
        CaptchaServiceSingleton.instance = instance;
        LOG.info("CaptchaServiceSingleton.instance...");
    }

    public static ImageCaptchaService getInstance() {
        return instance;
    }
}
