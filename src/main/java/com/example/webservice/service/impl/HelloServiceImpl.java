package com.example.webservice.service.impl;

import com.example.webservice.service.FileWriterService;
import com.example.webservice.service.HelloService;

import javax.jws.WebService;

@WebService(
        serviceName = "Hello",
        portName = "HelloPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "com.example.webservice.service.HelloService"
)
public class HelloServiceImpl implements HelloService {

    private FileWriterService fileWriterService;

    @Override
    public String sayHello(String name) {
        if (name == null || name.isEmpty()) {
            return "enter a valid name";
        }
        fileWriterService.writeName(name);
        return "Hello " + name;
    }

    public void setFileWriterService(FileWriterService fileWriterService) {
        this.fileWriterService = fileWriterService;
    }
}
