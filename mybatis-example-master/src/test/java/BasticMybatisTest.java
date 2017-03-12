/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-10-24 17:21 创建
 *
 */

import repository.AccountRepository;
import entity.account.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

/**
 * @author jxilong@yiji.com
 */
public class BasticMybatisTest {
	
	private Logger logger = LoggerFactory.getLogger(BasticMybatisTest.class);
	
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("basticBatisConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	
	/*xml方式实现*/
	@Test
	public void testBasticMybatis() {
		SqlSession session = getSession().openSession();
		try {
			Account account = session.selectOne("repository.AccountDao.selectByAccountNo", "1");
			logger.info("account object　【{}】", account);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testBasticMybatisInterface() {
		SqlSession session = getSession().openSession();
		try {
			AccountRepository accountRepository = session.getMapper(AccountRepository.class);
			logger.info("account object　【{}】", accountRepository.selectByAccountNo("1"));
		} finally {
			session.close();
		}
	}
}
