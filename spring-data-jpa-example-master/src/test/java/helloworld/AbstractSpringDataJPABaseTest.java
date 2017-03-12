/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-18 22:47 创建
 *
 */
package helloworld;

import jpa.entities.basic.BasicTypeRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author jxilong@yiji.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:config/*.xml")
public abstract class AbstractSpringDataJPABaseTest {
	
	static {
		System.getProperties().setProperty("yiji.appName", "glory");
	}
	
	@Autowired
	protected BasicTypeRepository basicTypeRepository;
	
	@Autowired
	protected EntityManagerFactory entityManagerFactory;
	
	protected EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
