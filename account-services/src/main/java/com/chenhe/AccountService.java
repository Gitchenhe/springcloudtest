package com.chenhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 账户服务
 *
 * @author chenhe
 */

/**
 * exclude = {DataSourceAutoConfiguration.class} 解决循环依赖
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class AccountService {
    public static void main(String[] args) {
        SpringApplication.run(AccountService.class, args);
        System.out.println("账户服务启动成功");
    }
}
