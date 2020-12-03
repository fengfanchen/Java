package cn.it1995.tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CalTool {

    public Float add(Float value1, Float value2){

        return value1 + value2;
    }

    public String getFile(){

        String ret = "";

        Properties properties = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("it1995.properties");
        try {

            properties.load(in);
        } catch (IOException e) {

            e.printStackTrace();
        }

        String str = properties.getProperty("name");
        System.out.println(properties);

        return ret;
    }
}
