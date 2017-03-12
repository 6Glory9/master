/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-13 16:48 创建
 *
 */
package activiti.task;

import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import activiti.AtivitiBaseTest;

/**
 * @author jxilong@yiji.com
 */
public class ClaimTaskTest extends AtivitiBaseTest {
	
	private static String DEPLOYMENT_RESOURCE = "deploymentResources/claimTask.bpmn";
	
	private static String PROCESS_DEFINITION_KEY = "claimTask";
	
	@Test
	public void testClassClaim() {
		clean();
		
		deploy(DEPLOYMENT_RESOURCE);
		
		ProcessInstance processInstance = start(PROCESS_DEFINITION_KEY);
		
	}
}
