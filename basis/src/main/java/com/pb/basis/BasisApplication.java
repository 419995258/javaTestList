package com.pb.basis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class BasisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasisApplication.class, args);
    }

}
