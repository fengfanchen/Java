package webservice.client;

import webservice.WeatherServiceImpl;
import webservice.WeatherServiceImplService;

public class Main {

    public static void main(String[] args) {

        WeatherServiceImplService serviceImplService =new WeatherServiceImplService();
        WeatherServiceImpl port = serviceImplService.getPort(WeatherServiceImpl.class);

        String query = port.query("南京");
        System.out.println(query);
    }
}
