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
        if (fileWriterService.writeUniqueName(name)) {
            return "Hello " + name + " - write a unique name";
        } else {
            return " this name is already in the file";
        }
    }

    public void setFileWriterService(FileWriterService fileWriterService) {
        this.fileWriterService = fileWriterService;
    }
}
