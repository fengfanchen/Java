package com.example.demo.controller;

import com.example.demo.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class TestController {

    private final ResourceLoader resourceLoader;

    public TestController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    @RequestMapping("test")
    private String toUpload(){

        return "test";
    }

    //上传文件
    @RequestMapping("fileUpload")
    public String upload(@RequestParam("fileName") MultipartFile file, Map<String, Object> map){

        String localPath = "F:/SpringTest";
        String msg = "";

        StringBuffer newName = new StringBuffer();
        if(FileUtils.upload(file, localPath, file.getOriginalFilename(), newName)){

            msg = "上传成功";
        }
        else{

            msg = "上传失败";
        }

        newName.toString();


        map.put("msg", msg);
        //map.put("fileName", file.getOriginalFilename());
        map.put("fileName",  newName.toString());

        return "forward:/test";
    }


    //显示单张图片
    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName){

        if(fileName == null){

            return ResponseEntity.notFound().build();
        }

        try{

            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        }
        catch (Exception e){

            return ResponseEntity.notFound().build();
        }
    }
}
