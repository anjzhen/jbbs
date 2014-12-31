package cc.ymee.jbbs.module.index;

import cc.ymee.common.spring.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>jbbs Create by 14/12/30 下午5:29</p>
 *
 * @author :anjero
 * @version :1.0
 */

@Controller
@RequestMapping
public class IndexController extends BaseController{

    private static final long serialVersionUID = 2319103966420198956L;

    @RequestMapping("/index.html")
    public String index(Model model, String theme) {
        model.addAttribute("theme", theme);
        return "index";
    }
}
