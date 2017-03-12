package ioc.beanfactories;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by jxilong on 2016/3/20.
 */
public class BeanFactoryTest {
	
	@Test
	public void testBeanFactory() {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resouce = resourceLoader.getResource("spring/spring-ioc.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resouce);
	}
}
