package com.pb.xcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xdf.xcloud.sentinel.SentinelProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sentinelC")
public class testController {

    @Autowired
    private SentinelProperties sentinelProperties;


    @GetMapping(value = "/test")
    public String test(@RequestParam("id") String id) {
        if("1".equals(id)){
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return "123";
    }

    @GetMapping(value = "/test2")
    public String test2(@RequestParam("id") String id) {
        if("1".equals(id)){
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return "123";
    }

    @GetMapping(value = "/sentinelProperties")
    public String sentinelProperties() {
        return sentinelProperties.getDegradeRules().toString();
    }

}
