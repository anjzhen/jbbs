package cc.ymee.common.spring.controller;


import cc.ymee.common.core.exception.ForbiddenJsonException;
import cc.ymee.jbbs.module.security.pojo.SecurityAdmin;
import cc.ymee.jbbs.module.security.service.AdminService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author :Anjero
 * @version :1.0
 * @Title :BaseAdminController.java
 * @Description:
 * @Datetime :2013-8-23
 * @Copyright :Copyright (c) 2012
 *
 */
@Controller
public class BaseAdminController extends BaseController {


    @Resource
    AdminService adminService;


    public SecurityAdmin getAdmin() throws ForbiddenJsonException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SecurityAdmin admin = (SecurityAdmin) request.getSession().getAttribute(SESSION_ADMIN);
        if (admin == null) {
            UserDetails details = adminUser();
            if (details != null) {
                String username = details.getUsername();
                admin = adminService.login(username);
                if (admin != null) {
                    request.getSession().setAttribute(SESSION_ADMIN, admin);
                }
            }
        }
        return admin;
    }

    public Integer getAdminId() throws ForbiddenJsonException {
        if (getAdmin() != null) {
            return getAdmin().getId();
        }
        throw new ForbiddenJsonException("未登录或超时，请重新登录！");
    }

    public UserDetails adminUser() throws ForbiddenJsonException {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userDetails;
        } catch (Exception e) {
            throw new ForbiddenJsonException("未登录或超时，请重新登录！");
        }
    }

}
