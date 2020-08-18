package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {

    private static final Log LOG = LogFactory.getLog(CustomEndpointInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {


        LOG.info("CustomEndpointInterceptor handleRequest");
        System.out.println("CustomEndpointInterceptor handleRequest");
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object o) throws Exception {

        LOG.info("CustomEndpointInterceptor handleResponse");
        System.out.println("CustomEndpointInterceptor handleResponse");
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) throws Exception {

        LOG.info("CustomEndpointInterceptor handleFault");
        System.out.println("CustomEndpointInterceptor handleFault");
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws Exception {

        LOG.info("CustomEndpointInterceptor afterCompletion");
        System.out.println("CustomEndpointInterceptor afterCompletion");
    }
}
