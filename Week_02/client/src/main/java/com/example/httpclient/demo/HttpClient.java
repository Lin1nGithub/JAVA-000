package client.src.main.java.com.example.httpclient.demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/10/28 19:36
 */
@Service
public class HttpClient {

    public void sendGetRequest(String url) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("Receive Message: " + content + " ,Length: " + content.length() );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
    }
}
