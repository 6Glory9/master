package utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by jxilong on 2016/8/16.
 */
public abstract class HttpClientBaseTest {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected final static String HTTP_PROTOCL = "http://";
	
	protected final static String https_protocl = "https://";
	
	protected final static String BAI_DU = "www.baidu.com";
	
	protected String builderAddress(String protocl, String domain) {
		return protocl + domain;
	}
	
	private void closeResponse(CloseableHttpResponse response) {
		try {
			if (response != null) {
				response.close();
			}
		} catch (IOException e) {
			logger.warn("关闭response异常", e);
		}
	}
	
	private void closeHttpClient(CloseableHttpClient closeableHttpClient) {
		try {
			if (closeableHttpClient != null) {
				closeableHttpClient.close();
			}
		} catch (IOException e) {
			logger.warn("关闭closeableHttpClient异常", e);
		}
	}
	
	private void logResponse(CloseableHttpResponse response) throws IOException {
		logger.info("status:{}", response.getStatusLine());
		logger.info("entity:{}", EntityUtils.toString(response.getEntity()));
		//EntityUtils.consume(response.getEntity());
	}
	
	private void logRequest(HttpRequestBase request) throws IOException {
		logger.info("Executing request: {}", request.getRequestLine());
	}
	
	protected void httpClientInvokeTemplate(HttpRequestBase request, CloseableHttpClient... closeableHttpClients) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		if (closeableHttpClients != null) {
			httpclient = closeableHttpClients[0];
		}
		
		CloseableHttpResponse response = null;
		try {
			logRequest(request);
			response = httpclient.execute(request);
			logResponse(response);
		} catch (Exception e) {
			logger.info("httpclient 调用出来异常", e);
		} finally {
			closeResponse(response);
			closeHttpClient(httpclient);
		}
	}
}
