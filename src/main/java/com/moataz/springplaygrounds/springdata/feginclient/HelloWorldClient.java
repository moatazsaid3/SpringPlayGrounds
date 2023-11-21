package com.moataz.springplaygrounds.springdata.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "helloworld")
@Async
public interface HelloWorldClient {
    @GetMapping("/helloworld/hello/sayHello")
    String getHello();
}
