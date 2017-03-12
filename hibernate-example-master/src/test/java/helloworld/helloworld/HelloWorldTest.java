/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-18 22:42 创建
 *
 */
package helloworld.helloworld;

import helloworld.AbstractHibernateBaseTest;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * @author jxilong@yiji.com
 */
public class HelloWorldTest extends AbstractHibernateBaseTest {
	
	@Test
	public void testHello() {
		
	}

	@Test
	public void testSchemaExport() {
		SchemaExport schemaExport = new SchemaExport(configuration);
		schemaExport.create(true,true);
	}
}
