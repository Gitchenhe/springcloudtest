package com.chenhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 * @author chenhe
 */
@SpringBootApplication
//允许向服务中心注册
@EnableDiscoveryClient
//开启断路由
@EnableHystrix
//开启图形界面(访问 http://localhost:<port>/hystrix)
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        System.out.println("APP 启动成功");
    }

    @Bean
    //必须加上这个注解,否则ribbon 无法送过service-id调用相应的服务,报错unknown host.
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
