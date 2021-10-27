package com.ocp7bibliotheque.bibliothequeeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BibliothequeEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeEurekaApplication.class, args);
    }

}
