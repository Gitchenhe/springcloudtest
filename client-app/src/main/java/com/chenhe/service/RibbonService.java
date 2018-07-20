package com.chenhe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenhe
 * @Date 2018-07-13 9:53
 * @desc
 **/
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;


    public String sayHello() {
        return restTemplate.getForObject("", String.class);
    }
}

