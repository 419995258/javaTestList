package com.pb.hystrix.controller;

import com.pb.hystrix.feign.HystrixFeign;
import com.pb.hystrix.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/hystrixC")
public class testController {

    @Autowired
    private HystrixFeign hystrixFeign;

    @Autowired
    private TestService testService;

    @GetMapping(value = "/timeOut")
    public String timeout(@RequestParam("time") Integer time) {
        return testService.timeOut(time);
    }


    @GetMapping(value = "/test")
    public String test(@RequestParam("id") Integer id) {
        return testService.test(id);
    }

}
