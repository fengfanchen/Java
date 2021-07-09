package cn.client;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.URI;
import java.security.KeyStore;

@SpringBootApplication
public class ClientMain implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    @Value("${endpoint.server-app}")
    private String msEndpoint;

    @Bean
    public RestTemplate getRestTemplate(){

        RestTemplate restTemplate = new RestTemplate();

        KeyStore keyStore;
        HttpComponentsClientHttpRequestFactory requestFactory = null;

        try {
            keyStore = KeyStore.getInstance("jks");
            ClassPathResource classPathResource = new ClassPathResource("client-app.jks");
            InputStream inputStream = classPathResource.getInputStream();
            keyStore.load(inputStream, "client-app".toCharArray());

            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(new SSLContextBuilder()
                    .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                    .loadKeyMaterial(keyStore, "client-app".toCharArray()).build(),
                    NoopHostnameVerifier.INSTANCE);

            HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory)
                    .setMaxConnTotal(Integer.valueOf(5))
                    .setMaxConnPerRoute(Integer.valueOf(5))
                    .build();

            requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            requestFactory.setReadTimeout(Integer.valueOf(10000));
            requestFactory.setConnectTimeout(Integer.valueOf(10000));

            restTemplate.setRequestFactory(requestFactory);
        }
        catch (Exception exception) {

            System.out.println("Exception Occured while creating restTemplate "+exception);
            exception.printStackTrace();
        }
        return restTemplate;
    }

    public static void main(String[] args) {

        SpringApplication.run(ClientMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String forObject = restTemplate.getForObject(new URI(msEndpoint), String.class);
        System.out.println(forObject);
    }
}
