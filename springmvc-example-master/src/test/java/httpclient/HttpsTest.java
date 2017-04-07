package httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import javax.net.ssl.SSLContext;
import java.io.UnsupportedEncodingException;

/**
 * Created by jxilong on 2017/3/17.
 */
public class HttpsTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testHttps() throws UnsupportedEncodingException {
		for (int i = 0; i < 50; i++) {
			StopWatch stopWatch = new StopWatch("test[" + i + "]");
			stopWatch.start();
			
			String data = "appid=xxxxxx&body=【四包】尤妮佳MOO**L54片&mch_id=m20160808000000506&nonce_str=yjf20170317112065387467&notify_url=http://ftransfer.yiji.com/paymentgw/pay/bsNotify/cibwx_public.htm&openid=oDI8hs7AIHhf9fXYtmsOV8DlDJFg&out_trade_no=20170317112065387467&spbill_create_ip=116.19.116.21&total_fee=43600&trade_type=JSAPI&key=d75e86b95ac08d12b041e480536f17cf";
			
			StringEntity dataEntity = new StringEntity(data, "UTF-8");
			
			sendMessage("https://www.baidu.com/s", 443, dataEntity, "UTF-8");
			
			stopWatch.stop();
			log.info(stopWatch.toString());
			
		}
	}
	
	public static HttpClient wrapClient(HttpClient httpclient, int port) {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL");
			ctx.init(null, new TrustManager[] { new TrustManager() }, null);
			
			SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			ClientConnectionManager ccm = httpclient.getConnectionManager();
			Scheme sch = new Scheme("https", port, ssf);
			httpclient.getConnectionManager().getSchemeRegistry().register(sch);
			return new DefaultHttpClient(ccm, httpclient.getParams());
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public String sendMessage(String url, int port, HttpEntity httpEntity, String resEncoding) {
		String respMsg = "";
		HttpPost httpPost = null;
		try {
			httpPost = new HttpPost(url);
			httpPost.addHeader("Connection", "close");
			if (httpEntity.getContentType() != null) {
				httpPost.addHeader(httpEntity.getContentType());
			}
			
			httpPost.setEntity(httpEntity);
			
			HttpClient httpclient = new DefaultHttpClient();
			if (url.startsWith("https://")) {
				httpclient = wrapClient(httpclient, port);
			}
			
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity resEntity = response.getEntity();
			
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && resEntity != null) {
				respMsg = EntityUtils.toString(resEntity, resEncoding);
			}
			
		} catch (Exception e) {
			log.error("Error when sending message to {}", url);
		} finally {
			if (httpPost != null) {
				httpPost.releaseConnection();
			}
		}
		return respMsg;
	}
}
