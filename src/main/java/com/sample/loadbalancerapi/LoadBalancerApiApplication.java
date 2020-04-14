package com.sample.loadbalancerapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class LoadBalancerApiApplication {


    @Value("${server.port}")
    public String port;

    @GetMapping("/chat")
    public String chatNow() {
        return "Your chat application is now running on Port: "+ port;
    }


    public static void main(String[] args) {
        SpringApplication.run(LoadBalancerApiApplication.class, args);
    }

}
