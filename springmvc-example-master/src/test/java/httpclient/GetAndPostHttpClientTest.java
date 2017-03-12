package httpclient;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharsetUtils;
import org.junit.Test;
import utils.HttpClientBaseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jxilong on 2016/8/16.
 */
public class GetAndPostHttpClientTest extends HttpClientBaseTest {
	
	private CloseableHttpClient httpclient = HttpClients.createDefault();
	
	@Test
	public void testGet() {
		
		httpClientInvokeTemplate(new HttpGet(builderAddress(HTTP_PROTOCL, BAI_DU)));
	}
	
	@Test
	public void testPost() {
		
		httpClientInvokeTemplate(builderPostWithParamRequest());
		
	}
	
	private HttpPost builderPostWithParamRequest() {
		HttpPost httpPost = new HttpPost(builderAddress(HTTP_PROTOCL, BAI_DU));
		
		List<NameValuePair> nvps = new ArrayList<>();
		nvps.add(new BasicNameValuePair("username", "vip"));
		nvps.add(new BasicNameValuePair("password", "secret"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, CharsetUtils.lookup("UTF-8")));
		
		return httpPost;
	}
}
