package cn.minio.test;

import io.minio.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;


@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    void saveFile(InputStream inputStream, String saveFile){
        try (
             OutputStream outputStream = new FileOutputStream(saveFile)) {

            // 读取源文件数据并写入目标文件
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("文件保存成功！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run(String... args) throws Exception {

        MinioClient minioClient = MinioClient.builder()
                        .endpoint("http://192.168.36.128:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();

        minioClient.makeBucket(MakeBucketArgs
                .builder()
                .bucket("user1")
                .build());

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\cff\\Desktop\\test.pdf");

        ObjectWriteResponse writeResponse = minioClient.putObject(PutObjectArgs
                .builder()
                .bucket("user1")
                .object("test.pdf")
                .stream(fileInputStream, fileInputStream.available(), -1).build());

        System.out.println("writeResponse : " + writeResponse.etag() + " " + writeResponse.versionId());

        try (InputStream stream =
                     minioClient.getObject(GetObjectArgs
                             .builder()
                             .bucket("user1")
                             .object("test.pdf")
                             .build())) {
            // Read the stream
            saveFile(stream, "C:\\Users\\cff\\Desktop\\test2.pdf");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
