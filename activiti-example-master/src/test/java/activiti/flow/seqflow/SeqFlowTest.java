/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 21:44 创建
 *
 */
package activiti.flow.seqflow;

import activiti.AtivitiBaseTest;
import activiti.service.BaseRole;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jxilong@yiji.com
 *
 *
 * SELECT * FROM ACT_RE_PROCDEF WHERE KEY_ = 'seqFlow' AND (TENANT_ID_ = '' OR
 * TENANT_ID_ IS NULL) AND VERSION_ = (SELECT MAX(VERSION_) FROM ACT_RE_PROCDEF
 * WHERE KEY_ = 'seqFlow' AND (TENANT_ID_ = '' OR TENANT_ID_ IS NULL))
 */
public class SeqFlowTest extends AtivitiBaseTest {
	
	@Test
	public void testA() {
		repositoryService.createDeployment().name("xxx-first").category("xxx-test")
			.addClasspathResource("deploymentResources/seqFlow.bpmn").deploy();
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("seqFlow");
		
		ProcessInstance processInstanceDB = runtimeService.createProcessInstanceQuery()
			.processInstanceId(processInstance.getProcessInstanceId()).singleResult();
		
		Assert.assertEquals(processInstance.getId(), processInstanceDB.getId());
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId())
			.singleResult();
		
		Assert.assertEquals(task.getAssignee(), BaseRole.xiaoming.name());
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("condition", "a");
		taskService.complete(task.getId(), paramMap);
		
		Task nextTask = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId())
			.singleResult();
		
		Assert.assertEquals(nextTask.getAssignee(), BaseRole.peigen.name());
		
		taskService.complete(nextTask.getId());
		
		ProcessInstance lastProcessInstance = runtimeService.createProcessInstanceQuery()
			.processInstanceId(processInstance.getProcessInstanceId()).singleResult();
		Assert.assertNull(lastProcessInstance); //finished
		
		Assert.assertEquals(2,
			historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstance.getProcessInstanceId())
				.list().size());
		
	}
	
	@Test
	public void testB() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("seqFlow");
		
		ProcessInstance processInstanceDB = runtimeService.createProcessInstanceQuery()
			.processInstanceId(processInstance.getProcessInstanceId()).singleResult();
		
		Assert.assertEquals(processInstance.getId(), processInstanceDB.getId());
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId())
			.singleResult();
		
		Assert.assertEquals(task.getAssignee(), BaseRole.xiaoming.name());
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("condition", "b");
		taskService.complete(task.getId(), paramMap);
		
		Task nextTask = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId())
			.singleResult();
		
		Assert.assertNull(nextTask);
		
		ProcessInstance lastProcessInstance = runtimeService.createProcessInstanceQuery()
			.processInstanceId(processInstance.getProcessInstanceId()).singleResult();
		Assert.assertNull(lastProcessInstance); //finished
		
		Assert.assertEquals(1,
			historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstance.getProcessInstanceId())
				.list().size());
		Assert.assertEquals(
			3,
			historyService.createHistoricActivityInstanceQuery()
				.processInstanceId(processInstance.getProcessInstanceId()).list().size());
	}
}
