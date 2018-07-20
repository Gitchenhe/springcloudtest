package com.chenhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式配置文件中心
 *
 * @author chenhe
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class,args);
        System.out.println("配置中心启动成功");
    }
}
