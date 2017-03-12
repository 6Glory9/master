package ioc;

import org.junit.Test;
import org.springframework.core.io.*;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.support.ServletContextResource;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by jxilong on 2016/3/19.
 */
public class ResourceTest {
	
	/**
	 * 常看到四类Resouce
     * 由于记取的位置不同，使用不同Resource来表示
	 */
	@Test
	public void testResourceKind() throws MalformedURLException {
		
		ClassPathResource classPathResource = new ClassPathResource("*");
		
		UrlResource urlResource = new UrlResource("*");
		
		ServletContextResource servletContextResource = new ServletContextResource(null, "/WEB-INF");
		
		FileSystemResource fileSystemResource = new FileSystemResource("*");
	}

    /**
     * getReader方法，根据charset进行inputStream->Reader
     */
    @Test
    public void testEncode() {
        ClassPathResource classPathResource = new ClassPathResource("*");
        EncodedResource encodedResource = new EncodedResource(classPathResource,"UTF-8");
    }

    /**
     *ResourceLoader 根据不同地址加载不同Resource但只能加载一个Resource
     *ResourcePatternResolver 在ResourceLoader可以加载多个Resource
     *
     *
     * classpath:根目录获取是getResource
     * classpath*:根目录获取是getResources
     */
    @Test
    public void testResourceLoder() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        resourceLoader.getResource("");

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        resourcePatternResolver.getResources("classpath*:");

    }
}
