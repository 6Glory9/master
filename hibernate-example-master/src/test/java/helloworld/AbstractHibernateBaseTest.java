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

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jxilong@yiji.com
 */
public abstract class AbstractHibernateBaseTest {

	protected Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	protected SessionFactory sessionFactory = configuration.buildSessionFactory();
	protected Logger logger = LoggerFactory.getLogger(getClass());


}
