/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 19:19 创建
 *
 */
package activiti.service;

import activiti.AtivitiBaseTest;
import entity.account.Account;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class VariablesTest extends AtivitiBaseTest {
	private Account account = new Account();
	
	{
		account.setAccountAlias("alias");
		Date createDate = new Date();
		account.setRawAddTime(createDate);
		account.setRawUpdateTime(createDate);
	}
	
	@Before
	public void testBefore() {
		runtimeService.startProcessInstanceByKey("helloWorld");
	}
	
	@Test
	public void testExecutionVariablesWay() {
		Execution execution = getActivatedExecution();
		runtimeService.setVariable(execution.getId(), account.getAccountAlias(), account);
		Account newAccount = (Account) runtimeService.getVariable(execution.getId(), account.getAccountAlias());
		logger.info(newAccount.toString());
	}
	
	@Test
	public void testTaskVariablesWay() {
		Task task = getActivatedLastNewUserTask();
		taskService.setVariable(task.getId(), account.getAccountAlias(), account);
		taskService.setVariableLocal(task.getId(), account.getAccountAlias() + "local", account);
		
		taskService.complete(task.getId());
		task = getActivatedLastNewUserTask();
		Account newAccount = (Account) taskService.getVariable(task.getId(), account.getAccountAlias());
		Account newLocalAccount = (Account) taskService.getVariable(task.getId(), account.getAccountAlias() + "local");
		logger.info("newAccount[{}]", newAccount);
		logger.info("newLocalAccount[{}]", newLocalAccount);
	}
	
	private Execution getActivatedExecution() {
		return runtimeService.createExecutionQuery().list().get(0);
	}
	
	public Task getActivatedLastNewUserTask() {
		return taskService.createTaskQuery().orderByTaskCreateTime().desc().list().get(0);
	}
}
