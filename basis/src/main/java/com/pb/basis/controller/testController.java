package com.pb.basis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/basicC")
public class testController {

    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/test")
    public String test() {

        String str = "basic：test ，port：" + serverPort;
        try {
            System.out.println(str);
//             Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }

}
