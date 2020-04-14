package com.sample.loadbalancerapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "chatapp", configuration = RibbonConfiguration.class)
public class LoadBalancerApplication {

    @Autowired
    private RestTemplate template;

    @GetMapping("/invoke")
    public String invokeChatapp() {
        String url = "http://chatapp/chat";
                return template.getForObject(url, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LoadBalancerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {

        return new RestTemplate();
    }
}
