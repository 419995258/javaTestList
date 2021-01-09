package com.pb.basis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/basicC")
public class testController {


    @GetMapping(value = "/test")
    public String test() {

        try {
            System.out.println("basic：test");
             Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "basic：test";
    }

}
