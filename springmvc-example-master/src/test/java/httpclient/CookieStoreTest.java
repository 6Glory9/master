package httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import utils.HttpClientBaseTest;

import java.io.IOException;

/**
 * Created by jxilong on 2017-03-14.
 */
public class CookieStoreTest extends HttpClientBaseTest {

    private final static String CQGJ_LOGIN_HTML_URL = "www.cqgjj.cn/html/user/login.html?UserType=gr";
    private final static String CQGJ_LOGIN_ASPX_URL = "www.cqgjj.cn/Member/UserLogin.aspx?UserType=gr";

    @Test
	public void testCookieStore() throws IOException {
		HttpContext httpContext = new HttpClientContext();

		CloseableHttpResponse closeableHttpResponse = builderCookieStoreHttpClient().execute(new HttpGet(builderAddress(HTTP_PROTOCL, CQGJ_LOGIN_ASPX_URL)),httpContext);

		String html = EntityUtils.toString(closeableHttpResponse.getEntity());

		Document document = Jsoup.parse(html);
		Elements __VIEWSTATE_element = document.select("#__VIEWSTATE");
		Elements __VIEWSTATEGENERATOR_element = document.select("#__VIEWSTATEGENERATOR");
		Elements __EVENTVALIDATION_element = document.select("#__EVENTVALIDATION");


		logger.info(document.toString());
	}
	
	private CloseableHttpClient builderCookieStoreHttpClient() {
        return HttpClients.custom().build();
	}
}
