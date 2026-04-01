package com.alq.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author alq
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SearchStarterApp {

    public static void main(String[] args) {
        SpringApplication.run(SearchStarterApp.class,args);
    }
}
