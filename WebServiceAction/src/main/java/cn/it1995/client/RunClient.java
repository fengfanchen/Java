package cn.it1995.client;

import cn.it1995.GetTestResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URISyntaxException;

public class RunClient {

    public static void main(String[] args) throws URISyntaxException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        IT1995Client client = context.getBean(IT1995Client.class);
        GetTestResponse response = client.getTest(1);
        System.out.println(response.getMyTest().getId());
        System.out.println(response.getMyTest().getName());
    }
}
