package cn.demo.webService;

import javax.jws.WebService;

@WebService
public interface WeatherService {

    String query(String cityName);
}
