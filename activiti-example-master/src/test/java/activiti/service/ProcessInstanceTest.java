/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 18:19 创建
 *
 */
package activiti.service;

import activiti.AtivitiBaseTest;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import java.util.List;

/**
 * @author jxilong@yiji.com 启动流程实例 1.act_ru_execution 增加一条记录 2.act_hi_procinst
 * 增加一条记录 ps:流程实例 串行流程，只会有一条执行对象 流程实例 并行流程, 会有多条执行对象
 */
public class ProcessInstanceTest extends AtivitiBaseTest {
	
	@Test
	public void testStartProcessInstance() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("helloWorld");
		printProcessInstance(processInstance);
	}
	
	@Test
	public void testQueryExecution() {
		List<Execution> executionList = runtimeService.createExecutionQuery().list();
		for (Execution execution : executionList) {
			printExecution(execution);
		}
	}
	
	@Test
	public void testQueryProcessInstance() {
		List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery().active().list();
		for (ProcessInstance processInstance : processInstanceList) {
			printProcessInstance(processInstance);
		}
	}
	
	@Test
	public void testQueryProcessInstanceStatus() {
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId("")
			.singleResult();
		if (processInstance == null) {
			logger.info("processInstance completed");
		} else {
			logger.info("processInstance running");
		}
	}
}
