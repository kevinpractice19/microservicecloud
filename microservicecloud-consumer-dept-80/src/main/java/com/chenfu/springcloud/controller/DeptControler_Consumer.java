package com.chenfu.springcloud.controller;

import com.chenfu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControler_Consumer {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 直接调用微服务名称，微服务名称在yml文件spring.application.name 微服务注册到eureka上面服务名变成大写
     * 所以此处应填写eureka上面的服务名，因为ribbon的作用是负载均衡，那么你直接使用ip地址，那么就无法起到
     * 负载均衡的作用，因为每次都是调用同一个服务，当你使用的是服务名称的时候，他会根据自己的算法去选择具有该服务名称的服务。
     */
    //    private static final String URL = "http://localhost:8001/";
    private static final String URL = "http://MICROSERVICECLOUD-DEPT";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(URL + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable int id) {
        return restTemplate.getForObject(URL + "/dept/get/"+id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(URL + "/dept/list", List.class);
    }
}
