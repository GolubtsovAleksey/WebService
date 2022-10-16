package com.example.webservice.config;

import com.example.webservice.service.FileWriterService;
import com.example.webservice.service.HelloService;
import com.example.webservice.service.impl.HelloServiceImpl;
import org.apache.cxf.Bus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public HelloService helloService(FileWriterService fileWriterService){
        HelloServiceImpl helloService = new HelloServiceImpl();
        helloService.setFileWriterService(fileWriterService);
        return helloService;
    }
    @Bean
    public Endpoint helloEndpoint(HelloService helloService){
        EndpointImpl endpoint = new EndpointImpl(bus,helloService);
        endpoint.publish("/ServiceHello");
        return endpoint;
    }


}
