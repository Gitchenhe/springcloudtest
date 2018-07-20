package com.chenhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 账户服务
 * @author chenhe
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AssetsService {
    public static void main(String[] args) {
        SpringApplication.run(AssetsService.class, args);
        System.out.println("资产服务启动成功");
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
