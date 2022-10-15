package com.example.webservice.service.impl;

import com.example.webservice.service.HelloService;

import javax.jws.WebService;

@WebService(
        serviceName = "Hello",
        portName = "HelloPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "com.example.webservice.service.HelloService"
)
public class HelloServiceImp implements HelloService {

    @Override
    public String sayHello(String name) {
        if (name == null || name.isEmpty()){
            return "Sanya ebobanuy kAzel!!!";
        }
        return "Hello " + name;
    }
}
