package com.ocp7bibliotheque.bibliothequespringcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableConfigServer
public class BibliothequeSpringCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeSpringCloudConfigApplication.class, args);
    }

}
