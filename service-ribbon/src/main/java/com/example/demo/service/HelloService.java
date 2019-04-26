package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhaoda
 */
@Service
public class HelloService {

    /**
     * 通过之前注入ioc容器的restTemplate来消费service-hi服务的“/client”接口
     */
    @Resource
    RestTemplate restTemplate;

    public String hiService(String name) {
       return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }
}
