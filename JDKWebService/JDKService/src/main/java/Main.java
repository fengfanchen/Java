import webservice.WeatherServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:9999/weatherService", new WeatherServiceImpl());
        System.out.println("发布成功");
    }
}
