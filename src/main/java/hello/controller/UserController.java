package hello.controller;

import hello.domain.User;
import hello.service.dao.UserDao;
import hello.service.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xiaohu on 14-3-20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @ModelAttribute
    public User getUser(@RequestParam(required = false) Integer id) {
        if(id == null) {
            User user = new User();
            return user;
        }
        else
            return userDao.find(id);
    }

    @RequestMapping(value = {"list", ""})
    public String loadHomePage(Model model) {
        List<User> users = userDao.list();
        model.addAttribute("users", users);
        return "user/list";
    }
    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String viewUser() {
        //model.addAttribute("user", user);
        return "user/view";
    }
    @RequestMapping(value = {"edit", "new"})
    public String editUser() {
        return "user/edit";
    }
    @RequestMapping(value = "update")
    public String updateUser(User user) {
        System.out.println(">>>>>>>> " + user);
        userDao.update(user);
        System.out.println(">>>>>>>> Id = " + user.getId());
        userDao.update(new User("xin", "mima", "xin"));
        return "user/success";
    }
    @RequestMapping(value = "test")
    public String testCase() {
        userDao.update(new User("UPDATE", "mima", "xin"));
        userDao.add(new User("ADD", "mima", "xin"));
        return "user/success";
    }
}

