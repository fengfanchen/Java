package cn.it1995.client;

import cn.it1995.GetTestRequest;
import cn.it1995.GetTestResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.addressing.client.ActionCallback;

import java.net.URI;
import java.net.URISyntaxException;

public class IT1995Client extends WebServiceGatewaySupport {

    public GetTestResponse getTest(int id) throws URISyntaxException {

        GetTestRequest request = new GetTestRequest();
        request.setId(id);

        ActionCallback callback = new ActionCallback(
                new URI("http://it1995.cn/getTestRequest")
        );

        return (GetTestResponse)getWebServiceTemplate().marshalSendAndReceive(request, callback);
    }
}
