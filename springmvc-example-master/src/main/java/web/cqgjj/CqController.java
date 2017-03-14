package web.cqgjj;

import form.CqForm;
import form.CqInfo;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.ConvertEnum;
import web.BaseController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by jxilong on 2017/3/14.
 */
@Controller
public class CqController extends BaseController {
	
	private final static String CQGJ_LOGIN_ASPX_URL = "http://www.cqgjj.cn/Member/UserLogin.aspx?UserType=null";
	private final static String CQGJ_CODE_ASPX_URL = "http://www.cqgjj.cn/Code.aspx";
	private final static String CQGJ_INFO_ASPX_URL = "http://www.cqgjj.cn/Member/gr/gjjyecx.aspx";
	
	private final static Map<String, HttpClientContext> cache = new HashMap<>();
	
	private final static List<ConvertEnum> loginConverUtils = ConvertEnum.getLogin();
	
	private final static List<ConvertEnum> infoConverUtils = ConvertEnum.getInfo();
	
	@RequestMapping("/cq/jumpIndex")
	public String jumpIndex(Model model) {
		model.addAttribute("requestId", System.currentTimeMillis());
		return "/cq/index";
	}
	
	@RequestMapping("/cq/viewCode")
	public void viewVerificationCode(String requestId, HttpServletResponse response) {
		
		try {
			HttpClientContext httpContext = new HttpClientContext();
			
			CloseableHttpResponse tokenReponse = HttpClients.custom().build()
				.execute(builderGetRequest(CQGJ_LOGIN_ASPX_URL), httpContext);
			
			parseTokenAndStore(httpContext, tokenReponse);
			
			cache.put(requestId, httpContext);
			
			CloseableHttpResponse verificationCodeReponse = HttpClients.custom().build()
				.execute(builderGetRequest(CQGJ_CODE_ASPX_URL), httpContext);
			
			verificationCodeReponse.getEntity().writeTo(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
			//TODO
		}
		
	}
	
	private void parseTokenAndStore(HttpClientContext httpContext, CloseableHttpResponse response) throws IOException {
		
		Document document = Jsoup.parse(EntityUtils.toString(response.getEntity()));
		
		for (ConvertEnum elementName : loginConverUtils) {
			String token = parseToken(document, elementName.getSelectKey());
			
			if (token != null) {
				httpContext.setAttribute(elementName.getSelectKey(), token);
			}
		}
		
	}
	
	@RequestMapping("/cq/login")
	@ResponseBody
	public CqInfo login(CqForm form) throws IOException {
		
		doLogin(form);
		
		CloseableHttpResponse infoResponse = HttpClients.custom().build().execute(builderGetRequest(CQGJ_INFO_ASPX_URL),
			getClientContext(form));

        cache.remove(form.getRequestId());

        return parseInfo(infoResponse);
		
	}
	
	private CqInfo parseInfo(CloseableHttpResponse infoResponse) throws IOException {
		Document document = Jsoup.parse(EntityUtils.toString(infoResponse.getEntity()));
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(new CqInfo());
		
		Map<String, String> props = new HashMap<>();
		for (ConvertEnum convertName : infoConverUtils) {
			String fliedValue = getText(document, convertName.getSelectKey());
			props.put(convertName.getInputTextName(), fliedValue);
			
		}
		
		bw.setPropertyValues(props);

		logger.info(bw.getWrappedInstance().toString());

		return (CqInfo) bw.getWrappedInstance();
	}
	
	private CloseableHttpResponse doLogin(CqForm form) throws IOException {
		return HttpClients.custom().build().execute(builderPostWithParamRequest(form), getClientContext(form));
	}
	
	/**
	 * txt_loginname Glory txt_pwd jiangxi0613 txt_code RSB2D but_send
	 * @return
	 */
	private HttpPost builderPostWithParamRequest(CqForm form) {
		List<NameValuePair> params = new ArrayList<>();
		addBaisInfo(form, params);
		
		addTokens(form, params);
		
		HttpPost httpPost = new HttpPost(CQGJ_LOGIN_ASPX_URL);
		
		httpPost.setEntity(new UrlEncodedFormEntity(params, CharsetUtils.lookup("UTF-8")));
		
		return httpPost;
	}
	
	private HttpClientContext getClientContext(CqForm form) {
		HttpClientContext httpClientContext = cache.get(form.getRequestId());
		
		if (httpClientContext == null) {
			//TODO
		}
		
		return httpClientContext;
	}
	
	private void addTokens(CqForm form, List<NameValuePair> params) {
		
		for (ConvertEnum elementName : loginConverUtils) {
			String token = getClientContext(form).getAttribute(elementName.getSelectKey(), String.class);
			if (token == null) {
				//TODO
			}
			params.add(new BasicNameValuePair(elementName.getInputTextName(), token));
		}
		
	}
	
	private void addBaisInfo(CqForm form, List<NameValuePair> params) {
		params.add(new BasicNameValuePair("txt_loginname", form.getLoginName()));
		params.add(new BasicNameValuePair("txt_pwd", form.getPassword()));
		params.add(new BasicNameValuePair("txt_code", form.getCode()));
		params.add(new BasicNameValuePair("but_send", ""));
	}
	
	private HttpGet builderGetRequest(String url) {
		return new HttpGet(url);
	}
	
	private Element parseElement(Document document, String id) {
		return document.select(id) != null ? document.select(id).get(0) : null;
	}
	
	private String parseToken(Document document, String id) {
		return getValue(document, id);
	}
	
	private String getText(Document document, String id) {
		return parseElement(document, id) != null ? parseElement(document, id).text() : null;
	}
	
	private String getValue(Document document, String id) {
		return parseElement(document, id) != null ? parseElement(document, id).val() : null;
	}
}
