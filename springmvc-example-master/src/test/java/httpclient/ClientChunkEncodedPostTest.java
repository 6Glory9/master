package httpclient;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import utils.HttpClientBaseTest;

import java.io.IOException;

/**
 * Created by jxilong on 2016/8/16.
 */
public class ClientChunkEncodedPostTest extends HttpClientBaseTest {
	
	@Test
	public void testChunkResouce() {
		httpClientInvokeTemplate(builderChunkResouceRequest());
	}
	
	private HttpPost builderChunkResouceRequest() {
		HttpPost httppost = null;
		try {
			httppost = new HttpPost(builderAddress(HTTP_PROTOCL, BAI_DU));
			
			Resource resource = new ClassPathResource("logback.xml");
			
			InputStreamEntity reqEntity = new InputStreamEntity(resource.getInputStream(), -1,
				ContentType.APPLICATION_OCTET_STREAM);
			reqEntity.setChunked(true);
			
			httppost.setEntity(reqEntity);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return httppost;
	}

}
