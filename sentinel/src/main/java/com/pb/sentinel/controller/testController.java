package com.pb.sentinel.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sentinelC")
public class testController {



    @GetMapping(value = "/test")
    @SentinelResource
    public String test() {
        return "123";
    }

}
