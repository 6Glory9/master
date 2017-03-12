package httpclient;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import utils.HttpClientBaseTest;

/**
 * Created by jxilong on 2016/8/16.
 */
public class ClientAuthenticationHttpClientTest extends HttpClientBaseTest {

    @Test
    public void testClientAuthentication() {

        httpClientInvokeTemplate(new HttpGet(builderAddress(HTTP_PROTOCL, BAI_DU)), builderCredentialsHttpClient());

    }

    private CloseableHttpClient builderCredentialsHttpClient() {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();

        credsProvider.setCredentials(new AuthScope(BAI_DU, 80), new UsernamePasswordCredentials("user", "passwd"));

        return HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();

    }
}
