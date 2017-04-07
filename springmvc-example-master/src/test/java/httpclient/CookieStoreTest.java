package httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import utils.HttpClientBaseTest;

import java.io.IOException;

/**
 * Created by jxilong on 2017-03-14.
 */
public class CookieStoreTest extends HttpClientBaseTest {
	
	private final static String CQGJ_LOGIN_HTML_URL = "www.cqgjj.cn/html/user/login.html?UserType=gr";
	private final static String CQGJ_LOGIN_ASPX_URL = "www.cqgjj.cn/Member/UserLogin.aspx?UserType=gr";
	private final static String CQGJ_CODE_ASPX_URL = "www.cqgjj.cn/Code.aspx";

	@Test
	public void testCookieStore() throws IOException {
		HttpContext httpContext = new HttpClientContext();
		
		CloseableHttpResponse closeableHttpResponse = builderCookieStoreHttpClient()
			.execute(new HttpGet("https://passport.jd.com/new/login.aspx"), httpContext);


		CloseableHttpResponse codeResponse = builderCookieStoreHttpClient()
				.execute(new HttpGet(builderAddress(HTTP_PROTOCL, CQGJ_CODE_ASPX_URL)), httpContext);
		
		String html = EntityUtils.toString(closeableHttpResponse.getEntity());
		logger.info(html);
		
		Document document = Jsoup.parse(html);
		
		String __VIEWSTATE = getValue(document, "#__VIEWSTATE");
		String __VIEWSTATEGENERATOR = getValue(document, "#__VIEWSTATEGENERATOR");
		String __EVENTVALIDATION = getValue(document, "#__EVENTVALIDATION");

		//TODO 获取验证码


		builderCookieStoreHttpClient().execute(builderLoginForm(__VIEWSTATE, __VIEWSTATEGENERATOR, __EVENTVALIDATION), httpContext);

		logger.info(document.toString());
	}

	private HttpUriRequest builderLoginForm(String viewstate, String viewstategenerator, String eventvalidation) {
		return null;
	}

	private CloseableHttpClient builderCookieStoreHttpClient() {
		return HttpClients.custom().build();
	}
	
	private Element parseElement(Document document, String id) {
		return document.select(id).get(0);
	}
	
	private String getValue(Document document, String id) {
		return parseElement(document, id).val();
	}
}
