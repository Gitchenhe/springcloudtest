package com.chenhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 账户服务
 * @author chenhe
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountService {
    public static void main(String[] args) {
        SpringApplication.run(AccountService.class, args);
        System.out.println("账户服务启动成功");
    }
}
