package client.src.main.java.com.example.httpclient.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/10/28 19:38
 */
@RestController
public class Api {

    @Autowired
    private HttpClient httpClient;

    @GetMapping("/test")
    public void sendGetRequest() throws Exception {

        httpClient.sendGetRequest("http://localhost:8808/test");
    }
}
