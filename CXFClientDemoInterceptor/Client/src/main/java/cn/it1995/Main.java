package cn.it1995;

import cn.it1995.interceptor.AddHeaderInterceptor;
import cn.it1995.service.MyService;
import cn.it1995.service.MyServiceService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

public class Main {

    public static void main(String[] args){

        MyServiceService service = new MyServiceService();
        MyService myService = service.getMyServicePort();

        Client myClient = ClientProxy.getClient(myService);
        myClient.getOutInterceptors().add(new AddHeaderInterceptor("ABC", "1234567"));
        myClient.getInInterceptors().add(new LoggingInInterceptor());;
        myClient.getOutInterceptors().add(new LoggingOutInterceptor());
        myService.getRoles();
    }
}
