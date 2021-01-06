package com.pb.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@DefaultProperties(defaultFallback="default_fallback") // 默认的fallback
public class TestService {

    // =====服务降级
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String timeOut(Integer timeOutNumber) {
        if(timeOutNumber == null){
            timeOutNumber = 3;
        }
        // int age  = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeOutNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName()  + "\t" + "  耗时(秒): " + timeOutNumber;
    }

    private String timeOutHandler(Integer timeOutNumber) {
        return "线程池:  " + Thread.currentThread().getName() + "  系统繁忙或者运行报错，请稍后再试" ;
    }

    //=====服务熔断
    @HystrixCommand(fallbackMethod = "testService_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    public String test(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        return Thread.currentThread().getName() + "\t" + "调用成功，当前时间戳: " + new Date().getTime() + ";id：" + id;
    }

    private String testService_fallback(Integer id) {
        return "id 不能负数，请稍后再试，id: " + id;
    }

    private String default_fallback(){
        return "默认";
    }
}
