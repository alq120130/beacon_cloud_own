package com.alq.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther:
 * @Date: 2026/3/29 - 03 - 29 - 21:26
 * @Description: com.alq.api
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {
        "com.alq.api",
        "com.alq.common"
})
public class ApiStarterApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiStarterApp.class, args);
    }
}
