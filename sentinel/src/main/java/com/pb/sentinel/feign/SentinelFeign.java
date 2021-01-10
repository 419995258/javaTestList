package com.pb.sentinel.feign;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
//@FeignClient(url = "localhost:8081", name = "sentinelFeign",fallbackFactory = SentinelFeignFactory.class)
@FeignClient(value = "cloud-basic-service",fallbackFactory = SentinelFeignFactory.class)
public interface SentinelFeign {

//    @RequestMapping(value = "/basicC/test",method = RequestMethod.GET)
    @GetMapping("/basicC/test")
    String test();


}
