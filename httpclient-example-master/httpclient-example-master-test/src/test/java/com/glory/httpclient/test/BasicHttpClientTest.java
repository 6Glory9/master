package com.glory.httpclient.test;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jxilong on 2017/2/19.
 */
public class BasicHttpClientTest {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testPost() {
		post();
		
	}
	
	private CloseableHttpResponse post() {
		try {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("param1", "value1"));
			formparams.add(new BasicNameValuePair("param2", "value2"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
			HttpPost httppost = new HttpPost("https://www.baidu.com");
			httppost.setEntity(entity);
			return HttpClients.createDefault().execute(httppost);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 响应所有的信息
	 */
	@Test
	public void testConsumeEntity() {
		try {
			CloseableHttpResponse response = post();
			logger.info("all header，{}", Arrays.asList(response.getAllHeaders()));
			logger.info("statusLine，{}", response.getStatusLine());
			logger.info("protocolVersion，{}", response.getProtocolVersion());
			logger.info("local，{}", response.getLocale());
			logger.info("entity...................");
			logger.info("ContentEncoding,{}",response.getEntity().getContentEncoding());
			logger.info("ContentLength,{}",response.getEntity().getContentLength());
			logger.info("ContentType,{}",response.getEntity().getContentType());
			logger.info("Content consume");
			//消费实例
			//EntityUtils.consume(response.getEntity());

			//直接断开http
			//response.close();
			//重复实例，可以重复操作
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				//缓存实体,可以通过消费实体来断开http
				entity = new BufferedHttpEntity(entity);
			}
			logger.info("Content byte,{}", EntityUtils.toByteArray(entity));
			logger.info("Content string,{}", EntityUtils.toString(entity));
			logger.info("entity...................");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
