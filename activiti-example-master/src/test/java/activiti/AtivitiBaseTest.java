/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 17:33 创建
 *
 */
package activiti;

import com.yjf.common.lang.util.DateUtil;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jxilong@yiji.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:activiti.cfg.xml")
public abstract class AtivitiBaseTest {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected RepositoryService repositoryService;
	
	@Autowired
	protected TaskService taskService;
	
	@Autowired
	protected RuntimeService runtimeService;
	
	@Autowired
	protected HistoryService historyService;
	
	@Autowired
	protected ManagementService managementService;
	
	static {
		System.getProperties().setProperty("yiji.appName", "xxx");
	}
	
	protected void printDeployment(Deployment deployment) {
		logger.info("------------------------------------");
		logger.info("ID----{}", deployment.getId());
		logger.info("NAME----{}", deployment.getName());
		logger.info("DEPLOYMENTTIME----{}", DateUtil.simpleFormat(deployment.getDeploymentTime()));
		logger.info("CATEGORY----{}", deployment.getCategory());
		logger.info("TENANTID----{}", deployment.getTenantId());
		logger.info("------------------------------------");
	}
	
	protected void printProcessDefinition(ProcessDefinition processDefinition) {
		logger.info("------------------------------------");
		logger.info("ID----{}", processDefinition.getId());
		logger.info("KEY[ProcessDefinition-id]----{}", processDefinition.getKey());
		logger.info("NAME[ProcessDefinition-name]----{}", processDefinition.getName());
		logger.info("DEPLOYMENTID----{}", processDefinition.getDeploymentId());
		logger.info("RESOURCENAME----{}", processDefinition.getResourceName());
		logger.info("------------------------------------");
	}
	
	protected void printProcessInstance(ProcessInstance processInstance) {
		logger.info("------------------------------------");
		logger.info("ID----{}", processInstance.getId());
		logger.info("PROCESSINSTANCEID----{}", processInstance.getProcessInstanceId());
		logger.info("NAME----{}", processInstance.getName());
		logger.info("DEPLOYMENTID----{}", processInstance.getDeploymentId());
		logger.info("PROCESSDEFINITIONKEY----{}", processInstance.getProcessDefinitionKey());
		logger.info("PROCESSDEFINITIONNAME----{}", processInstance.getProcessDefinitionName());
		logger.info("ACTIVITYID----{}", processInstance.getActivityId());
		logger.info("------------------------------------");
	}
	
	protected void printExecution(Execution execution) {
		logger.info("------------------------------------");
		logger.info("ID----{}", execution.getId());
		logger.info("PROCESSINSTANCEID----{}", execution.getProcessInstanceId());
		logger.info("ACTIVITYID----{}", execution.getActivityId());
		logger.info("------------------------------------");
	}
	
	protected void printUserTask(Task task) {
		logger.info("------------------------------------");
		logger.info("ID----{}", task.getId());
		logger.info("EXECUTIONID----{}", task.getExecutionId());
		logger.info("PROCESSINSTANCEID----{}", task.getProcessInstanceId());
		logger.info("PROCESSDEFINITIONID----{}", task.getProcessDefinitionId());
		logger.info("OWNER----{}", task.getOwner());
		logger.info("ASSIGNEE----{}", task.getAssignee());
		logger.info("CREATETIME----{}", DateUtil.simpleFormat(task.getCreateTime()));
		logger.info("------------------------------------");
	}
	
	protected void printHistoricTask(HistoricTaskInstance historicTaskInstance) {
		logger.info("------------------------------------");
		logger.info("ID----{}", historicTaskInstance.getId());
		logger.info("EXECUTIONID----{}", historicTaskInstance.getExecutionId());
		logger.info("PROCESSINSTANCEID----{}", historicTaskInstance.getProcessInstanceId());
		logger.info("PROCESSDEFINITIONID----{}", historicTaskInstance.getProcessDefinitionId());
		logger.info("OWNER----{}", historicTaskInstance.getOwner());
		logger.info("ASSIGNEE----{}", historicTaskInstance.getAssignee());
		logger.info("CREATETIME----{}", DateUtil.simpleFormat(historicTaskInstance.getCreateTime()));
		logger.info("ENDTIME----{}", DateUtil.simpleFormat(historicTaskInstance.getEndTime()));
		logger.info("------------------------------------");
	}
	
	protected void clean() {
		for (Deployment deployment : repositoryService.createDeploymentQuery().list()) {
			repositoryService.deleteDeployment(deployment.getId(), true);
		}
	}
	
	protected void deploy(String classpathResource) {
		repositoryService.createDeployment().name("xxx-first").category("xxx-test")
			.addClasspathResource(classpathResource).deploy();
	}

	protected ProcessInstance start(String key) {
		return runtimeService.startProcessInstanceByKey(key);
	}

}
