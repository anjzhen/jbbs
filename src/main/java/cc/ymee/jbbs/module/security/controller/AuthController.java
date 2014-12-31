package cc.ymee.jbbs.module.security.controller;

import cc.ymee.common.spring.controller.BaseController;
import cc.ymee.jbbs.module.security.pojo.SecurityAuth;
import cc.ymee.jbbs.module.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/security/auth/*")
public class AuthController extends BaseController {

    /**
     *
     */
    private static final long serialVersionUID = 6711368458958057535L;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request, Model model, @RequestParam(defaultValue = "0") Integer pid) {
        if (pid == 0) {
            pid = 1;
        }
        List<SecurityAuth> auths = authService.selectAll();
        model.addAttribute("auths", auths);
        List<SecurityAuth> list = authService.selectByPid(pid);
        model.addAttribute("list", list);
        model.addAttribute("id", pid);
        return "admin/security/auth/list";
    }

    @RequestMapping(value = "/add")
    public String add(Integer pid, Model model) {
        model.addAttribute("pid", pid);
        model.addAttribute("displayIndex", 99);
        return "admin/security/auth/add";
    }

    @RequestMapping(value = "/save")
    public String save(String name, String url, String displayName, Integer pid, Integer displayIndex, Model model) {
        SecurityAuth auth = new SecurityAuth();
        auth.setName(name);
        auth.setDisplayName(displayName);
        auth.setDisplayIndex(displayIndex);
        auth.setUrl(url);
        auth.setPid(pid);
        authService.save(auth);
        return redirect("/admin/security/auth/list?pid=" + pid);
    }

    @RequestMapping(value = "/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        SecurityAuth auth = authService.selectById(id);
        model.addAttribute("auth", auth);
        return "admin/security/auth/edit";
    }

    @RequestMapping(value = "/{id}/update")
    public String update(@PathVariable Integer id, String name, String url, String displayName, Integer pid, Integer displayIndex, Model model) {
        SecurityAuth auth = new SecurityAuth();
        auth.setName(name);
        auth.setDisplayName(displayName);
        auth.setDisplayIndex(displayIndex);
        auth.setUrl(url);
        auth.setPid(pid);
        auth.setId(id);
        authService.update(auth);
        return redirect("/admin/security/auth/list?pid=" + pid);
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        int count = authService.selectByPid(id).size();
        if (count > 0) {
            addAlertMessage(model, "请先删除子权限");
        } else {
            SecurityAuth auth = authService.selectById(id);
            authService.delete(id);
            id = auth.getPid();
        }
        return redirect("/admin/security/auth/list?pid=" + id);

    }

}
