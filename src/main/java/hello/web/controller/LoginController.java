package hello.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Xiaohu on 14-4-24.
 */

@Controller
@RequestMapping("/admin")
public class LoginController {
    @RequestMapping(value = "login")
    public String loadLoginPage() {
        return "admin/login";
    }
}
