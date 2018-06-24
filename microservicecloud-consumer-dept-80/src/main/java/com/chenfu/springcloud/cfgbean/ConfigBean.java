package com.chenfu.springcloud.cfgbean;

import com.chenfu.rule.RandoomRole_Custom;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //ribbon客户端负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * RetryRule  当所有的服务都正常的时候RetryRule和轮询的作用效果是一样的，当有服务突然挂掉的时候，RetryRule还是会去访问该服务
     * 在一定时间内多次访问无果之后，则不在访问该服务
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandoomRole_Custom();//达到目的，用我们重新选择的随机算法替代默认的轮训算法
    }
}
