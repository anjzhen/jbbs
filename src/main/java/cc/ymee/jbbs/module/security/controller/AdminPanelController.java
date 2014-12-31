package cc.ymee.jbbs.module.security.controller;


import cc.ymee.common.spring.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/")
public class AdminPanelController extends BaseAdminController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -809063117941584285L;


    @RequestMapping(value = "/dashboard")
    public String index() {
        return redirect("/admin/index");
    }
}
