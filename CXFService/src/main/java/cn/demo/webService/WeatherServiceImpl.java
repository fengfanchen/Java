package cn.demo.webService;

import java.util.Random;

public class WeatherServiceImpl implements WeatherService {


    public String query(String cityName) {

        Random random = new Random();
        int n = random.nextInt(3);
        System.out.println("The n is " + n);
        String ret = "null";
        switch (n){

            case 0:
                ret = "晴天";
                break;
            case 1:
                ret = "阴天";
                break;
            case 3:
                ret = "雨天";
        }
        return ret;
    }
}
