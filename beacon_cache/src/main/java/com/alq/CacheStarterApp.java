package com.alq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther:
 * @Date: 2026/3/30 - 03 - 30 - 12:55
 * @Description: com.alq
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CacheStarterApp {
    public static void main(String[] args) {
        SpringApplication.run(CacheStarterApp.class,args);
    }
}
