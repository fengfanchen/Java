package com.example.demo;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

class CountryClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://localhost:8080/ws/countries", request);
    }

}