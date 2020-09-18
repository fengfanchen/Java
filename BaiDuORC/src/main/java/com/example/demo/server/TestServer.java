package com.example.demo.server;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;


@Service
public class TestServer {

    @Autowired
    private RestTemplate restTemplate;

    private static String grantType = "client_credentials";
    private static String clientId = "it1995it1995it1995it1995it1995it1995";
    private static String clientSecret = "it1995it1995it1995it1995it1995it1995";

    protected String readFileWithBase64(String fileName){

        String ret = null;

        try{

            File file = new File(fileName);
            Long fileLength = file.length();
            byte[] fileContent = new byte[fileLength.intValue()];

            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();

            //进行Base64编码
            ret = Base64.getEncoder().encodeToString(fileContent);
        }
        catch (IOException e){

            e.printStackTrace();
        }

        return ret;
    }

    public void test(){

        //获取access_token
        String accessUrl = "https://aip.baidubce.com/oauth/2.0/token?grant_type=%0&client_id=%1&client_secret=%2";
        accessUrl = accessUrl.replace("%0", grantType).replace("%1", clientId).replace("%2", clientSecret);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(accessUrl, String.class);
        Map<String, String> tokenRetMap = JSON.parseObject(forEntity.getBody(), Map.class);
        if(!tokenRetMap.containsKey("access_token")){

            System.out.println("ERROR:" + forEntity.getBody());
            return;
        }

        String access_token = tokenRetMap.get("access_token");

        //读取图片
        String fileContent = readFileWithBase64("C:\\Users\\Administrator\\Desktop\\test\\1.jpg");

        //构造参数
        String orcUrl = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic?access_token=%0";
        orcUrl = orcUrl.replace("%0", access_token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, Object> paraMap = new LinkedMultiValueMap<>();
        paraMap.put("image", Collections.singletonList(fileContent));

        String orcRet = restTemplate.postForObject(orcUrl, new HttpEntity<>(paraMap, headers), String.class);
        System.out.println(orcRet);


        System.out.println("over");
    }
}
