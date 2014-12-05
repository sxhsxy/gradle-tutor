package hello.web.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Xiaohu on 14-4-24.
 */

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(value = "login")
    public String loginPage() {
        return "user/login";
    }

    @RequestMapping(value = "home")
    public String loadHomePage() {
//        SecurityUtils.getSubject().getPrincipal();
        return "user/home";
    }

    @RequestMapping(value = "logout")
    public String logoutPage() {
        return "user/login";
    }
}
