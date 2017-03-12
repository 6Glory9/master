/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-02-05 21:09 创建
 *
 */
package repository;

import trace.TradeTrace;

import java.util.List;

/**
 * @author jxilong@yiji.com
 */
public interface SuspicionRepository {
	
	void addSuspicion(String accountNo);
	
	List<String> listAllSuspicion();
	
	List<TradeTrace> selectNextSuspicion(String accountNo);
}
