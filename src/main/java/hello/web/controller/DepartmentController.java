package hello.web.controller;

import hello.domain.Department;
import hello.service.SystemService;
import hello.web.editor.DepartmentEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiaohu on 14-4-5.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
   @Autowired
    private SystemService systemService;

    @ModelAttribute
    public Department getDepartment(@RequestParam(required = false) Integer id) {
        if(id == null) {
            Department department = new Department();
            return department;
        }
        else
            return systemService.findDepartment(id);
    }

    @RequestMapping(value = {"list", ""})
    public String loadHomePage(@RequestParam(required = false, defaultValue = "1") Integer pageNoDisplay, Department department, Model model) {
        PageRequest pageRequest = new PageRequest(pageNoDisplay-1, 5);
        Page<Department> departmentPage = systemService.findDepartment(pageRequest, department);
        model.addAttribute("departmentPage", departmentPage);
        return "department/list";
    }
    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String viewDepartment() {
        //model.addAttribute("department", department);
        return "department/view";
    }
    @RequestMapping(value = {"edit", "new"})
    public String editDepartment() {
        return "department/edit";
    }
    @RequestMapping(value = "update")
    public String updateDepartment(Department department) {
        systemService.saveDepartment(department);
        return "redirect:list";
    }

    @RequestMapping(value = "delete")
    public String deleteDepartment(Department department) {
        systemService.deleteDepartment(department);
        return "redirect:list";
    }


}


