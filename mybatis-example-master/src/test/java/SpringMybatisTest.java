/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-10-24 17:56 创建
 *
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.AccountRepository;
import repository.SuspicionRepository;
import trace.TradeTrace;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.payengine.enums.CurrencyEnum;
import entity.account.Account;

/**
 * @author jxilong@yiji.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:druid.xml", "classpath*:springMybatisConfig.xml" })
public class SpringMybatisTest {
	
	private Logger logger = LoggerFactory.getLogger(BasticMybatisTest.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private SuspicionRepository suspicionRepository;
	
	@Test
	public void testSpring() {
		logger.info("account object　【{}】", accountRepository.selectByAccountNo("1"));
	}
	
	@Test
	public void testAddAccount() {
		Account account = new Account();
		account.setAccountNo("" + System.currentTimeMillis());
		account.setCurrency(CurrencyEnum.AED);
		account.setBalance(new Money(10));
		account.setAccountAlias("glory");
		
		logger.info("account object　【{}】", accountRepository.addAccount(account,"glory"));
	}
	
	@Test
	public void testSuspicion() {
		List<String> soucreSuspicions = suspicionRepository.listAllSuspicion();
		soucreSuspicions.add("20130310bj1218406912");
		Set<String> newSoucreSuspicions = new HashSet<>(soucreSuspicions);
		
		for (String soucreSuspicion : soucreSuspicions) {
			suspicion(newSoucreSuspicions, soucreSuspicion);
		}
		

		Iterator<String> iterator = newSoucreSuspicions.iterator();
        StringBuilder sql = new StringBuilder("(");
		while (iterator.hasNext()) {
            String accountNo = iterator.next();
            sql.append("'").append(accountNo).append("'").append(",");
		}

        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");

        logger.info(sql.toString());

    }
	
	private void suspicion(Set<String> suspicions, String accountNo) {
		List<TradeTrace> tradeTraces = suspicionRepository.selectNextSuspicion(accountNo);
		for (TradeTrace tradeTrace : tradeTraces) {
			String suspicion = suspicionTadeTrace(tradeTrace, suspicions);
			if (suspicion != null) {
				suspicion(suspicions, suspicion);
			}
		}
		
	}
	
	private String suspicionTadeTrace(TradeTrace tradeTrace, Set<String> suspicions) {
		if (suspicions.add(tradeTrace.getPayeeAccountNo())) {
			return tradeTrace.getPayeeAccountNo();
		} else if (suspicions.add(tradeTrace.getPayerAccountNo())) {
			return tradeTrace.getPayerAccountNo();
		}
		
		return null;
		
	}
	
}
