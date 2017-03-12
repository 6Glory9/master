/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-23 10:11 创建
 *
 */
package ioc.beanfactories;

import org.junit.Test;

/**
 * @author jxilong@yiji.com
 */
public class StringValueResolverTest {
	
	/**
	 * ${}表达式
	 * StringValueResolver PlaceholderResolvingStringValueResolver
	 * PropertyPlaceholderHelper:表达式分解
	 * 		parseStringValue:递归处理(actlKey:default)
	 * 		findPlaceholderEndIndex:嵌套占位符寻找
	 *
	 * PlaceholderResolver(Properties):数据获取工具,
	 * ,PropertyPlaceholderConfigurer.resolvePlaceholder方法
	 *
	 */
	@Test
	public void testEL() {
		
	}

	/**
	 *
	 * PlaceholderConfigurerSupport
	 *
	 * PropertyPlaceholderConfigurer
	 *
	 	PlaceholderConfigurerSupport 数据来自localURL
			doProcessProperties
				BeanDefinitionVisitor
				beanFactoryToProcess.resolveAliases
				beanFactoryToProcess.addEmbeddedValueResolver
	 * PropertySourcesPlaceholderConfigurer
	 * 	 1.数据获取来自父类PropertyResourceConfigurer工厂模板方法加载数据,来自localURL
		 2.可以由子类加密转换（PS）
		 3.processProperties(beanFactory, mergedProps)最终子类进行处理
		 PlaceholderConfigurerSupport 写了一个模板方法，由子类调用
		 StringValueResolver处理
		 4.最终子类组装数据和调用方式，实现processProperties(beanFactory, mergedProps)钩子
	 *
	 *
	 *
	 *PropertySourcesPlaceholderConfigurer
		 重写postProcessBeanFactory
		 propertySources：解析
		 appliedPropertySources:解析完成
		 environment:环境变量

		 processProperties方法
		 ConfigurablePropertyResolver

		 StringValueResolver重写
		 由ConfigurablePropertyResolver去处理
		 1.PropertyPlaceholderHelper自己重新创建
		 2.PlaceholderResolver由doResolvePlaceholders()->getPropertyAsRawString处理
	 */
	@Test
	public void clientTest() {

	}
}
