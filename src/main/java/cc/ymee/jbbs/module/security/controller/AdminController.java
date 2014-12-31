package cc.ymee.jbbs.module.security.controller;

import cc.ymee.common.spring.controller.BaseController;
import cc.ymee.jbbs.module.security.pojo.SecurityAdmin;
import cc.ymee.jbbs.module.security.pojo.SecurityRole;
import cc.ymee.jbbs.module.security.service.AdminService;
import cc.ymee.jbbs.module.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/security/adminuser/*")
public class AdminController extends BaseController {

    /**
     *
     */
    private static final long serialVersionUID = 9132996399379768374L;


    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<SecurityAdmin> list = adminService.selectAll();
        model.addAttribute("list", list);
        return "admin/security/admin/list";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        List<SecurityRole> roles = roleService.selectAll();
        model.addAttribute("roles", roles);
        return "admin/security/admin/add";
    }

    @RequestMapping(value = "/save")
    public String save(String username, String password, Integer role[], HttpServletRequest request) {
        Integer type = null;
        try {
            type = Integer.parseInt(request.getParameter("type"));
        } catch (NumberFormatException e) {
            type = 0;
        }
        SecurityAdmin securityAdmin = new SecurityAdmin();
        securityAdmin.setUsername(username);
        securityAdmin.setPassword(new Md5PasswordEncoder().encodePassword(password, username));
        securityAdmin.setType(type);
        securityAdmin = adminService.save(securityAdmin, role);
        return redirect("/admin/security/adminuser/list");
    }

    @RequestMapping(value = "/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        SecurityAdmin admin = adminService.selectById(id);
        List<SecurityRole> adminRoles = roleService.selectByAdmin(id);
        List<SecurityRole> roles = roleService.selectAll();
        model.addAttribute("admin", admin);
        model.addAttribute("adminRoles", adminRoles);
        model.addAttribute("roles", roles);

        return "admin/security/admin/edit";
    }

    @RequestMapping(value = "/{id}/update")
    public String update(@PathVariable Integer id, Integer role[], Integer venderIds[], Model model) {
        adminService.update(id, role);
        return redirect("/admin/security/adminuser/list");
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        adminService.delete(id);
        return redirect("/admin/security/adminuser/list");
    }

}
