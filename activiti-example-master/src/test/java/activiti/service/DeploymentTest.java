/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 17:35 创建
 *
 */
package activiti.service;

import activiti.AtivitiBaseTest;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;

import java.util.List;

/**
 * @author jxilong@yiji.com deploymentBuilder.deploy
 * <p/>
 * 1.act_re_deployment 部署对象表增加一条记录
 * 2.act_re_procdef    流程定义表增加一条记录 ref deployment_id
 * 3.act_ge_bytearray  资源文件表增加二条记录 ref depoloyment_id 两条（图片信息）
 * 4.act_ge_property   主键生成表
 */
public class DeploymentTest extends AtivitiBaseTest {
	
	@Test
	public void testSimapleDeployment() {
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().name("helloWorld-first")
			.category("category-test").tenantId("tenant-test")
			.addClasspathResource("deploymentResources/hellworld.bpmn");
		
		Deployment deployment = deploymentBuilder.deploy();
		
		printDeployment(deployment);
	}
	
	@Test
	public void testProcessDefinitionQuery() {
		List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
			.latestVersion().list();
		for (ProcessDefinition processDefinition : processDefinitionList) {
			printProcessDefinition(processDefinition);
		}
	}
	
}
