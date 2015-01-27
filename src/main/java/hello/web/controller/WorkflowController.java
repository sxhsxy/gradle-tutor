package hello.web.controller;

import hello.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohu on 15-1-25.
 */
@Controller
@RequestMapping("/workflow")
public class WorkflowController {
    @Autowired
    WorkflowService workflowService;


    @RequestMapping(value = {"deployment/list", ""})
    public String listDeployments(Model model)
    {
        model.addAttribute("deploymentList", workflowService.findDeployment());
       return "workflow/deploymentList";
    }
}
