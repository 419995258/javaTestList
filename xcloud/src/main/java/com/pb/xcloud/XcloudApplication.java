package com.pb.xcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient
@SpringBootApplication
public class XcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(XcloudApplication.class, args);
    }

}
