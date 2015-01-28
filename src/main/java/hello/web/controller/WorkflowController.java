package hello.web.controller;

import hello.service.WorkflowService;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiaohu on 15-1-25.
 */
@Controller
@RequestMapping("/workflow")
public class WorkflowController {
    @Autowired
    WorkflowService workflowService;

    private static final Logger logger = LoggerFactory.getLogger(WorkflowController.class);

    @RequestMapping(value = {"deployment/list", ""})
    public String listDeployments(@RequestParam(required = false, defaultValue = "1") Integer pageNumDisplay,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                  Model model)
    {
        PageRequest pageRequest = new PageRequest(pageNumDisplay-1, pageSize);
        Page<Deployment> deploymentPage = workflowService.findDeployment(pageRequest);
        logger.info("Number: {}, NumberOfElements: {}, TotalElements:{}, TotalPages: {}",deploymentPage.getNumber(),
                deploymentPage.getNumberOfElements(),
                deploymentPage.getTotalElements(),
                deploymentPage.getTotalPages());
        model.addAttribute("deploymentPage", deploymentPage);
       return "workflow/deploymentList";
    }

    @RequestMapping("deployment/delete")
    public String deleteDeployment(@RequestParam String id){
        workflowService.deleteDeployment(id);
        return "redirect:list";
    }

    @RequestMapping("deployment/new")
    public String deleteDeployment(){
        //workflowService.deleteDeployment(id);
        return "redirect:list";
    }

}
