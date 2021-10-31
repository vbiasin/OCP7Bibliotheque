package com.ocp7bibliotheque.bibliothequeconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BibliothequeConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeConfigServerApplication.class, args);
    }

}
