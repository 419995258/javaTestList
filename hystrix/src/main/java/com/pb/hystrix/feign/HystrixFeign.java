package com.pb.hystrix.feign;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(url = "localhost:8081", name = "hystrixFeign")
public interface HystrixFeign {


    @GetMapping("/basicC/test")
    String test();

}
