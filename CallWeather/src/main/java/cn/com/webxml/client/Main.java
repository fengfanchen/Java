package cn.com.webxml.client;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

import java.util.List;

public class Main {

    public static void main(String[] args){

        WeatherWS weatherWS = new WeatherWS();
        WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();

        List<String> ret = weatherWSSoap.getWeather("南京", null).getString();
        for(String item : ret){

            System.out.println(item);
        }
    }
}
