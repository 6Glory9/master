/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-13 16:10 创建
 *
 */
package activiti.flow.concurrentflow;

import activiti.AtivitiBaseTest;
import activiti.service.BaseRole;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author jxilong@yiji.com
 */
public class ConcurrentFlowTest extends AtivitiBaseTest {
	
	@Test
	public void testConcurrentDeploy() {

        clean();

		repositoryService.createDeployment().name("concurrent-test").category("category-test")
			.addClasspathResource("deploymentResources/concurrentFlow.bpmn").deploy();
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("parallel");
		
		List<Execution> executionList = runtimeService.createExecutionQuery()
			.processInstanceId(processInstance.getProcessInstanceId()).list();
		
		Assert.assertEquals(3, executionList.size());
		
		taskService.complete(getAssigneeTask(BaseRole.xiaoming.name()).getId());
		taskService.complete(getAssigneeTask(BaseRole.xiaoming.name()).getId());

        List<Execution> secondList = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getProcessInstanceId()).list();

        Assert.assertEquals(3, secondList.size());


        taskService.complete(getAssigneeTask(BaseRole.peigen.name()).getId());
        taskService.complete(getAssigneeTask(BaseRole.peigen.name()).getId());

	}

    private Task getAssigneeTask(String userName) {
        return taskService.createTaskQuery().taskAssignee(userName).singleResult();
    }

}
