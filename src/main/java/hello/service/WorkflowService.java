package hello.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaohu on 15-1-25.
 */
@Service
public class WorkflowService {

    private static final Logger logger = LoggerFactory.getLogger(WorkflowService.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    public List<Deployment> findDeployment() {
        return repositoryService.createDeploymentQuery().list();
    }

    public Page<Deployment> findDeployment(PageRequest pageRequest) {
        int offset = pageRequest.getOffset();
        int length = pageRequest.getPageSize();
        long total = repositoryService.createDeploymentQuery().count();
        logger.info("Offset:{}, Length:{}, Total:{}",offset,length,total);
        List<Deployment> content = repositoryService.createDeploymentQuery()
                .listPage(offset,offset+length);


        Page<Deployment> page = new PageImpl<Deployment>(content, null, total);
        return page;
    }

    public void deleteDeployment(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId);
    }
}
