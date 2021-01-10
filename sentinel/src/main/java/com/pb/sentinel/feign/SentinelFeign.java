package com.pb.sentinel.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(url = "localhost:8081", name = "sentinelFeign",fallbackFactory = SentinelFeignFactory.class)
public interface SentinelFeign {


    @GetMapping("/basicC/test")
    String test();

}
