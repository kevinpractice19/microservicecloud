package com.chenfu.springcloud;

import com.chenfu.rule.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient  //说明这是一个eureka客户端，用来处理ribbon负载均衡
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = CustomRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
