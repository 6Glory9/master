package web;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import form.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author jxilong@yiji.com
 */
public class HttpMessageConverControllerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testHttpMessage2JSON() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		User user = new User();
		user.setUserName("1");
		user.setPassword("1");
		HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);

		restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());

		ResponseEntity<User> userResponseEntity = restTemplate.exchange(
			"http://localhost:8080/httpMessageConver/json.htm", HttpMethod.GET, httpEntity,
			User.class);

        logger.info("resonpse[{}]",userResponseEntity.getBody());
		
	}
}