package webservice;

import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService {


    public String query(String cityName) {

        System.out.println("查询 " +cityName);

        return "晴天";
    }
}
