/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-10-24 17:56 创建
 *
 */

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.payengine.enums.CurrencyEnum;
import entity.account.Account;
import generator.entity.Transfer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import repository.AccountRepository;
import repository.SuspicionRepository;
import repository.TransferMapper;
import repository.TransferRepository;
import trace.TradeTrace;

import java.util.*;

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

	@Autowired
	private TransferRepository transferRepository;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private TransferMapper transferMapper;

	private List<String> bizNoList = Arrays.asList("004j00601h6o0ka2pk00", "004j00601h6o0ka2pm00", "004j00601h6o0ka2ms00",
			"004j00601h6o0ka2as00", "004j00601h6o0ka2bs00", "004j00601h6o0ka2cs00"
	);


	@Test
	public void testLock() throws InterruptedException {
		for(int i=0;i<250;i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					for(String bizNo:bizNoList) {
						lockAndUpdate(bizNo);
					}
				}
			});
			thread.start();

			thread.join();
		}



	}


	private void lockAndUpdate(final String bizNo) {
		try {
			transactionTemplate.execute(new TransactionCallback() {
                @Override
                public Object doInTransaction(TransactionStatus status) {
					Transfer transfer = transferMapper.lockByBizNo(bizNo);

					transferMapper.updateByPrimaryKey(transfer);
					logger.info("test transfer[{}]",transfer);
					return transfer;
                }
            });
		} catch (Exception e) {
			logger.info("异常问题出现",e);
		}
	}
	
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
