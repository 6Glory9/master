/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 20:35 创建
 *
 */
package activiti.service;

import activiti.AtivitiBaseTest;
import org.activiti.engine.history.HistoricTaskInstance;
import org.junit.Test;

import java.util.List;

/**
 * @author jxilong@yiji.com
 */
public class HistoryTest extends AtivitiBaseTest {
	
	@Test
	public void testQueryUserTask() {
		List<HistoricTaskInstance> historicTaskInstanceList = historyService.createHistoricTaskInstanceQuery().list();
		for (HistoricTaskInstance historicTask : historicTaskInstanceList) {
			printHistoricTask(historicTask);
		}
	}
}
