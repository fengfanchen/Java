package com.example.demo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static boolean upload(MultipartFile file, String path, String fileName, StringBuffer newName){

        String fileNewName = FileNameUtils.getFileName(fileName);
        //String realPath = path + "/" + FileNameUtils.getFileName(fileName);
        String realPath = path + "/" + fileNewName;
        newName.append(fileNewName);
        //String realPath = path + "/" + fileName;

        File dest = new File(realPath);

        //判断父目录是否存在
        if(!dest.getParentFile().exists()){

            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
        }
        catch (IllegalStateException e){

            e.printStackTrace();
            return false;
        }
        catch (IOException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }
}
