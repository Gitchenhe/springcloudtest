package com.chenhe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author chenhe
 * @Date 2018-07-12 18:17
 * @desc
 **/
@RestController
//开启SpringCloudConfig 的动态刷新功能,一定要配置在Controller上,否则拿不到最新值
@RefreshScope
public class InfoController {

    @Value("${server.port}")
    String port;

    /**
     * 读取配置中心配置
     */
    @Value("${version}")
    String version;

    /**
     * 读取配置中心配置
     */
    @Value("${description}")
    String desc;

    @RequestMapping("info")
    @ResponseBody
    public String info() {
        return "account service, listen on port " + port + ", desc: " + desc + ", version: " + version;
    }

    @RequestMapping("balance")
    @ResponseBody
    public Integer balance() {
        return 100;
    }


}
