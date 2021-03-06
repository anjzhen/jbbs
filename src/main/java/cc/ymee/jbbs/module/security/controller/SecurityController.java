package cc.ymee.jbbs.module.security.controller;


import cc.ymee.common.spring.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class SecurityController extends BaseAdminController{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7368679805049619254L;

	@RequestMapping(value = "/adminlogin")
	public String adminLogin(HttpServletRequest request,Model model){
		System.out.println("gays want to login");
		String error=request.getParameter("error");
		if(!StringUtils.isEmpty(error)){
			model.addAttribute("error", error);
		}
		return "admin/security/panel/login";
	}
}
