package com.chenhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * 微服务网关
 * @author chenhe
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinServer {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServer.class);
        System.out.println("调用追踪服务启动成功");
    }
}
