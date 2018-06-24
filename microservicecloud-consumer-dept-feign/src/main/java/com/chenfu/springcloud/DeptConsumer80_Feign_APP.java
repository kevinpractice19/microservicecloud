package com.chenfu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient  //说明这是一个eureka客户端，用来处理ribbon负载均衡
@EnableFeignClients(basePackages = {"com.chenfu.springcloud"})
@ComponentScan("com.chenfu.springcloud")
public class DeptConsumer80_Feign_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_APP.class, args);
    }
}
