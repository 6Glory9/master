package ioc;

import base.BaseTest;
import ioc.beans.Glory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jxilong on 2016/3/19. ClassLoader是用来加载class文件的加载器
 */
public class ClassLoaderTest extends BaseTest {
	
	@Test
	public void testHierarchical() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		logger.info("current loader【{}】", classLoader);
		logger.info("parent loader【{}】", classLoader.getParent());
		logger.info("grandParent loader【{}】", classLoader.getParent().getParent());
		
		/**
		 * AppClassLoader 系统加载器 加载classpath下的所有jar ExtClassLoader 扩展加载器
		 * 加载java_home下的ext目录的jar ClassLoader
		 * 根加载器(C++编写,所以为为空)，加载目录(jre目标下的rt.jar、charsets.jar)
		 * 加载类默认采用全盘负责委托机制方式加载class文件。简单来说当前引用某个jar时，
		 * 先由祖先加载，如祖先没有，再由父亲加载，最由才由当前Classloader加载
		 */
	}
	
	@Test
	public void testClassLoderMethod() throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<Glory> gloryClass = (Class<Glory>) classLoader.loadClass("ioc.beans.Glory");
		logger.info(gloryClass.toString());
		
		Class<Glory> gloryClass1 = (Class<Glory>) Class.forName("ioc.beans.Glory");
		
		Assert.assertEquals(gloryClass, gloryClass1);
		/**
		 * JVM默认只会存在三个类加载器，它们把类文件加载成Class实例，
		 * Class对象是为了描述类的信息,并且也会跟ClassLoader相关联
		 */
	}
	
	@Test
	public void testGetResourceDiffClass() {
		Class<Glory> gloryClass = Glory.class;
		ClassLoader classLoader = gloryClass.getClassLoader();
		logger.info("class getResource【{}】", gloryClass.getResource("Glory.class"));
		logger.info("class getResource【{}】", gloryClass.getResource("/"));
		logger.info("classLoader getResource【{}】", classLoader.getResource(""));
		logger.info("classLoader getResource【{}】",
			classLoader.getResource("/F:/codes/me/master/spring-example-master/target/classes/ioc/beans/Glory.class"));

        /**
         *class 默认是相对路径(当前package)去找,也可以从classpath("/")
         *classLoader 默认是从classpath路径去找,但不存在("/"),这样会返回NULL
         *
         */

    }
	
}
