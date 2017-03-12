/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-10-24 17:40 创建
 *
 */
package repository;

import entity.account.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @author jxilong@yiji.com
 */
public interface AccountRepository {
	
	Account selectByAccountNo(String accountNo);
	
	int addAccount(Account account,@Param("xx") String name);
	
}
