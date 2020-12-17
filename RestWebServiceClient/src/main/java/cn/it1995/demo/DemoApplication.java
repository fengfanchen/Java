package cn.it1995.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){

        return builder.build();
    }


    @Bean
    public CommandLineRunner runner(RestTemplate restTemplate){

        byte[] b = new byte[]{1, 2};
        System.out.println(b);

        return args -> {

            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            System.out.println(quote);
        };
    }
}
