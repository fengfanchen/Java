package cn.it1995.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("cn.it1995");
        return marshaller;
    }

    @Bean
    public IT1995Client it1995Client(Jaxb2Marshaller marshaller){

        IT1995Client client = new IT1995Client();
        client.setDefaultUri("http://localhost:8080/ws/it1995");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
