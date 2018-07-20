package com.chenhe.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenhe
 * @Date 2018-07-13 9:51
 * @desc
 **/
@RestController
public class RibbonTestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("accountInfo")
    @HystrixCommand(fallbackMethod ="hiError")
    public String accountInfo(){
        return restTemplate.getForObject("http://zuul-server/account/info",String.class);
    }

    @RequestMapping("assetsInfo")
    @HystrixCommand(fallbackMethod ="hiError")
    public String assetsInfo(){
        return restTemplate.getForObject("http://zuul-server/assets/info",String.class);
    }

    /**
     * client -> zuul -> assets -> account
     * @return
     */
    @RequestMapping("balance")
    @HystrixCommand(fallbackMethod ="hiError")
    public String balance(){
        return restTemplate.getForObject("http://zuul-server/assets/balance",String.class);
    }

    public String hiError(){
        return "网关响应超时!!!";
    }
}
