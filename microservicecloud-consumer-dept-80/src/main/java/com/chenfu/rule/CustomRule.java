package com.chenfu.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRule {

    @Bean
    public IRule myRule(){
        return new RandoomRole_Custom();  //ribbon默认是轮询， 我这里自定义为随机，看自定义的规则是否生效
    }
}
