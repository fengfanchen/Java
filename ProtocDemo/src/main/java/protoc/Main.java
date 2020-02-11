package protoc;

import protoc.object.TestProtocStruMsg;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        TestProtocStruMsg.TestProtocStru.Builder stru = TestProtocStruMsg.TestProtocStru.newBuilder();
        stru.setValue1("Hello world");
        stru.setValue2(10086);
        stru.setValue3(true);

        TestProtocStruMsg.TestProtocStru struMsg = stru.build();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        struMsg.writeTo(outputStream);

        //存起来，给C++解析
        byte[] byteArray = outputStream.toByteArray();

        File file = new File("file");
        if(file.exists()){

            if(!file.delete()){

                System.out.println("have file, delete failed");
                return;
            }
        }

        if(!file.createNewFile()){

            System.out.println("create file failed!");
            return;
        }

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);

        for(int i = 0; i < byteArray.length; i++) {

            fileWriter.write(byteArray[i]);
        }
        fileWriter.close();

        //存完啦

        //Java直接解析，C++等会再看
        ByteArrayInputStream input = new ByteArrayInputStream(byteArray);
        TestProtocStruMsg.TestProtocStru test = TestProtocStruMsg.TestProtocStru.parseFrom(input);
        System.out.println("value1: " + test.getValue1());
        System.out.println("value2: " + test.getValue2());
        System.out.println("value3: " + test.getValue3());
    }
}
