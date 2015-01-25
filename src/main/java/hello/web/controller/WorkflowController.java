package hello.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohu on 15-1-25.
 */
@Controller
@RequestMapping("/workflow")
public class WorkflowController {
    @RequestMapping(value = {"deployment/list", ""})
    public String listDeployments()
    {

       return "workflow/deploymentList";
    }
}
