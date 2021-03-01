package cn.it1995.service;

public class TestService {

    private String host;
    private Integer port;

    public TestService(String host, Integer port) {

        this.host = host;
        this.port = port;
    }

    public void printAll(){

        System.out.println("host: " + this.host + " , port:" + port);
    }
}
