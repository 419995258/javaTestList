package com.pb.sentinel.feign;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class SentinelFeignFactory implements FallbackFactory<SentinelFeign> {



    @Override
    public SentinelFeign create(Throwable throwable) {
        System.out.println("error  服务异常");
        return null;
    }
}
