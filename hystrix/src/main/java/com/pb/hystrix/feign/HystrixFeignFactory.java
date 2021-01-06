package com.pb.hystrix.feign;

import feign.hystrix.FallbackFactory;

public class HystrixFeignFactory implements FallbackFactory<HystrixFeign> {



    @Override
    public HystrixFeign create(Throwable throwable) {
        System.out.println("error  服务异常");
        return null;
    }
}
