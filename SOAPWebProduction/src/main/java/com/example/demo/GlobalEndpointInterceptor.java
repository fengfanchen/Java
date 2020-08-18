package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapElement;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.namespace.QName;
import java.util.Iterator;

@Component
public class GlobalEndpointInterceptor implements EndpointInterceptor {

    private static final Log LOG = LogFactory.getLog(GlobalEndpointInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {


        SoapMessage soapMessage = (SoapMessage) messageContext.getRequest();
        SoapHeader soapHeader = soapMessage.getSoapHeader();

        Iterator<SoapHeaderElement> qn = soapHeader.examineAllHeaderElements();
        while (qn.hasNext()) {

            SoapElement elem = qn.next();
            System.out.println(elem.toString());
        }
        Iterator<QName> an = soapHeader.getAllAttributes();
        while (an.hasNext()) {

            QName elem = an.next();
            System.out.println(elem.toString());
        }

        throw new Exception("UserToken Error");
//        LOG.info("GlobalEndpointInterceptor handleRequest");
//        System.out.println("GlobalEndpointInterceptor handleRequest");
//        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object o) throws Exception {

        LOG.info("GlobalEndpointInterceptor handleResponse");
        System.out.println("GlobalEndpointInterceptor handleResponse");
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) throws Exception {

        LOG.info("GlobalEndpointInterceptor handleFault");
        System.out.println("GlobalEndpointInterceptor handleFault");
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws Exception {

        LOG.info("GlobalEndpointInterceptor afterCompletion");
        System.out.println("GlobalEndpointInterceptor afterCompletion");
    }
}
