package hello.controller;

import hello.domain.User;
import hello.service.dao.UserDao;
import hello.service.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaohu on 14-3-20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = {"list", ""})
    public String loadHomePage(Model model) {
        List<User> users = userDao.list();
        model.addAttribute("users", users);
        return "user/list";
    }
    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String getUser(@RequestParam Integer id, Model model) {
        User user = userDao.find(id);
        model.addAttribute("user", user);
        return "user/view";
    }
    @RequestMapping(value = "edit")
    public String editUser(@RequestParam Integer id, Model model) {
        User user = userDao.find(id);
        model.addAttribute("user", user);
        return "user/edit";
    }
    @RequestMapping(value = "new")
    public String editUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/new";
    }
    @RequestMapping(value = "update")
    public String updateUser(User user, Model model) {
        System.out.println(user);
        //userDao.update(user);
        return "user/success";
    }
}

