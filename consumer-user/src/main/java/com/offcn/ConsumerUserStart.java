package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerUserStart {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserStart.class);
    }
    @LoadBalanced   //负载均衡
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

