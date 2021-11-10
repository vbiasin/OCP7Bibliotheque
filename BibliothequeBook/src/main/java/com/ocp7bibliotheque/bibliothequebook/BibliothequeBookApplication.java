package com.ocp7bibliotheque.bibliothequebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
public class BibliothequeBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeBookApplication.class, args);
    }

}
