package com.moataz.springplaygrounds.springdata.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("microservice")
@Log4j2
public class HelloWorldController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/sayHello")
    public String sayHello(){
        System.out.println("bounced the request to the helloworld microservice");
        return restTemplate.getForObject("http://helloworld/helloworld/hello/sayHello",String.class);
    }
}
