package ioc.beanfactories;

import org.junit.Test;
import org.springframework.core.env.*;
import org.springframework.jndi.JndiPropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;

/**
/**
 * Created by jxilong on 2016/3/20.
 * 属性分解器
 */
public class PropertyResolverTest {

    /**
     * PropertySources(MutablePropertySources)->List<PropertySource>
     * PropertySource（hashcode,equal都以name区分）
     * name:属性资源的名字
     * source:数据源
     *
     *
     * 1.JndiPropertySource->JndiLocatorDelegate
     * 2.EnumerablePropertySource系列的PropertySource
     *
     */
    @Test
    public void testJndiPropertySource() {
        PropertySource jndiPropertySource = new JndiPropertySource("jndi");
        //source = JndiLocatorDelegate
        //JndiLocatorDelegate.lookup->模板方法JndiLocatorSupport.lookUp
        //最终还是从jndiTemplate获取的
        Object jndi = jndiPropertySource.getProperty("jndi");

    }


    /**
     * PropertyResolver--->PropertySourcesPlaceholderConfigurer
     * 1.PropertySourcesPropertyResolver系列
     *      getProperty
     *      resolvePlaceholders
     *      如果是string，它会采用PropertyPlaceholderHelper处理
     * 2.Environment
     *
     *
     * StringValueResolver-->PropertyPlaceholderConfigurer
     * 只是单独对String进行获取，没有类型转换功能
     */
    @Test
    public void testPropertySourcesPropertyResolver() {

        MutablePropertySources propertySources = new MutablePropertySources();
        //propertySources.add();
        PropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);
        //propertyResolver.getProperty("")
        /**
         *
         * 内部使用PropertyPlaceholderHelper
         * 内部数据获取工具变成getPropertyAsRawString方式
         */
    }



    /*
        servletConfigInitParams
        servletContextInitParams
        jndiProperties
        systemProperties
        systemEnvironment
      */
    @Test
    public void testEnvironment() {

        MutablePropertySources propertySources = new MutablePropertySources();
        //propertySources.add();
        StandardServletEnvironment environment = new StandardServletEnvironment();
        //customizePropertySources
        //replace PropertySource
        environment.initPropertySources(null, null);
    }

}
