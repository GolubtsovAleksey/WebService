package com.example.WebService;

import javax.jws.WebService;

@WebService(
        serviceName = "Hello",
        portName = "HelloPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "com.example.WebService.HelloService"
)
public class HelloServiceImp implements HelloService{

    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
