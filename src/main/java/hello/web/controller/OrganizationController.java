package hello.web.controller;

import hello.domain.Organization;
import hello.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Xiaohu on 14-4-18.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private SystemService systemService;

    @ModelAttribute
    public Organization getOrganization(@RequestParam(required = false) Long id) {
        if(id == null) {
            Organization organization = new Organization();
            return organization;
        }
        else
            return systemService.findOrganization(id);
    }

    @ResponseBody
    @RequestMapping(value = "list/json")
    public List<Organization> listOrganization() {
        return systemService.findAllOrganization();
    }

}
