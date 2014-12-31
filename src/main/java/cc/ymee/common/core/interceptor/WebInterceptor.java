package cc.ymee.common.core.interceptor;


import cc.ymee.common.utils.IpUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * @author :anjero
 * @version :1.0
 * @Title :DwaInterceptor.java
 * @Description:
 * @Datetime : 2014-4-17 下午3:31
 * @Copyright :Copyright (c) 2012
 *
 */

public class WebInterceptor implements HandlerInterceptor {
    private static Logger log = Logger.getLogger("web");

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object object, Exception exception)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        String actionName = request.getRequestURI();
        String clientIp = IpUtil.getIpAddr(request);
        StringBuffer logstring = new StringBuffer();
        logstring.append(clientIp).append("|").append(actionName).append("|");
        Map<String, String[]> parmas = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iter = parmas.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String[]> entry = iter.next();
            logstring.append(entry.getKey());
            logstring.append("=");
            for (String paramString : entry.getValue()) {
                logstring.append(paramString);
            }
            logstring.append("|");
        }
        long executionTime = System.currentTimeMillis() - startTime;
        logstring.append("excutetime=").append(executionTime).append("ms");
        log.info(logstring.toString());
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object object,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }
}
