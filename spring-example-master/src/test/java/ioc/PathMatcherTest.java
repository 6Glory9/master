package ioc;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Map;

/**
 * Created by jxilong on 2016/3/20.
 */
public class PathMatcherTest extends BaseTest{
	
	@Test
	public void testPathMatcher() {
		PathMatcher pathMatcher = new AntPathMatcher();
		
		// /test/*.htm<->/test/xx.htm(xx.htm)
		String extractPath = pathMatcher.extractPathWithinPattern("/test/*.htm", "/test/xx.htm");
		Assert.assertEquals("xx.htm", extractPath);
		
		Map<String, String> extractUriTemplateVariables = pathMatcher.extractUriTemplateVariables("/test/{test}",
			"/test/xx.htm");

        logger.info("UriTemplateVariables【{}】",extractUriTemplateVariables);
	}
}
