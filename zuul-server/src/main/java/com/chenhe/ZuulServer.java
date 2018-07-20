package com.chenhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 微服务网关
 * @author chenhe
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServer {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServer.class);
        System.out.println("网关启动成功");
    }
}
