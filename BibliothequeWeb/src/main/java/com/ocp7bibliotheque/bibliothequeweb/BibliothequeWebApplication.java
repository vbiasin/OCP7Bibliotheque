package com.ocp7bibliotheque.bibliothequeweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ocp7bibliotheque.*"})
@EntityScan("com.ocp7bibliotheque.*")
public class BibliothequeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeWebApplication.class, args);
    }

}
