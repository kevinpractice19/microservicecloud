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

    private static final String URL = "http://localhost:8001/";
    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @RequestMapping(value = "/consumer/dept/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(URL + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get{id}")
    public Dept get(@PathVariable int id) {
        return restTemplate.getForObject(URL + "/dept/get"+id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(URL + "/dept/list", List.class);
    }
}
