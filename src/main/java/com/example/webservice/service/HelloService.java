package com.example.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(
        targetNamespace = "http://service.ws.sample/",
        name = "HelloService"
)
public interface HelloService {

    @WebResult(
            name = "return",
            targetNamespace = ""
    )
    @RequestWrapper(
            localName = "sayHelloReques",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.WebService.HelloServiceRequest"
    )
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(
            localName = "sayHelloResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.WebService.SayHelloResponse"
    )
    String sayHello(@WebParam(name = "name", targetNamespace = "") String name);
}
