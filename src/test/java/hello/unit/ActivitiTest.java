package hello.unit;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Xiaohu on 15-1-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ActivitiTest {
    @Autowired
    RepositoryService repositoryService;
    @Test
    public void deploymentProcessDefinition(){

        System.out.print("anything.");

        repositoryService.createDeployment().name("xxxxxxxxx");
        Deployment deployment = repositoryService//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("helloworld入门程序")//添加部署的名称
                .addClasspathResource("diagrams/helloworld.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("diagrams/helloworld.png")//从classpath的资源中加载，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署名称："+deployment.getName());//helloworld入门程序
    }
}
