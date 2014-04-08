package hello.web.controller;

import hello.domain.Department;
import hello.domain.User;
import hello.service.SystemService;
import hello.web.editor.DepartmentEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaohu on 14-3-20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SystemService systemService;

    @ModelAttribute
    public User getUser(@RequestParam(required = false) Integer id) {
        if(id == null) {
            User user = new User();
            return user;
        }
        else
            return systemService.findUser(id);
    }

    @RequestMapping(value = {"list", ""})
    public String loadHomePage(@RequestParam(required = false, defaultValue = "1") Integer pageNoDisplay, User user, Model model) {
        PageRequest pageRequest = new PageRequest(pageNoDisplay-1, 5);
        Page<User> userPage = systemService.findUser(pageRequest, user);
        model.addAttribute("userPage", userPage);
        return "user/list";
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String viewUser() {
        //model.addAttribute("user", user);
        return "user/view";
    }

    @RequestMapping(value = {"edit", "new"})
    public String editUser(Model model) {
        List<Department> departmentList = systemService.findAllDepartment();
        model.addAttribute("departmentList", departmentList);
        return "user/form";
    }

    @RequestMapping(value = "update")
    public String updateUser(User user) {
        System.out.print(user);
        systemService.saveUser(user);
        return "redirect:list";
    }

    @RequestMapping(value = "delete")
    public String deleteUser(User user) {
        systemService.deleteUser(user);
        return "redirect:list";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Department.class, new DepartmentEditor(systemService));
    }
}

