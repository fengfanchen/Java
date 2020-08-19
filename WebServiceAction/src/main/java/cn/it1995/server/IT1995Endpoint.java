package cn.it1995.server;

import cn.it1995.GetTestRequest;
import cn.it1995.GetTestResponse;
import cn.it1995.MyTest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;


@Endpoint
public class IT1995Endpoint {


    @Action("http://it1995.cn/getTestRequest")
    public @ResponsePayload
    GetTestResponse getTest(@RequestPayload GetTestRequest request){

        GetTestResponse response = new GetTestResponse();
        MyTest myTest = new MyTest();
        myTest.setId(request.getId());
        myTest.setName("Hello World");
        response.setMyTest(myTest);
        return response;
    }
}
