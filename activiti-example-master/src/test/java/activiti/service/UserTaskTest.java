/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 18:35 创建
 *
 */
package activiti.service;

import activiti.AtivitiBaseTest;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @author jxilong@yiji.com
 *
 * Execution 执行对象 按流程定义的规则执行一次的过程. 对应的表： act_ru_execution： 正在执行的信息
 * act_hi_procinst：已经执行完的历史流程实例信息 act_hi_actinst：存放历史所有完成的活动 ProcessInstance
 * 流程实例 特指流程从开始到结束的那个最大的执行分支，一个执行的流程中，流程实例只有1个。
 * 
 * 注意 （1）如果是单例流程，执行对象ID就是流程实例ID （2）如果一个流程有分支和聚合，那么执行对象ID和流程实例ID就不相同
 * （3）一个流程中，流程实例只有1个，执行对象可以存在多个。
 * 
 * Task 任务 执行到某任务环节时生成的任务信息。 对应的表： act_ru_task：正在执行的任务信息
 * act_hi_taskinst：已经执行完的历史任务信息
 */
public class UserTaskTest extends AtivitiBaseTest {
	
	@Test
	public void testQueryTaskAssignee() {
		List<Task> taskList = taskService.createTaskQuery().taskAssignee("glory").list();
		for (Task task : taskList) {
			printUserTask(task);
		}
	}
	
	@Test
	public void testComplete() {
		List<Task> taskList = taskService.createTaskQuery().taskAssignee("glory").list();
		for (Task task : taskList) {
			taskService.complete(task.getId());
		}
	}
}
