package com.ocp7bibliotheque.bibliothequeweb.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BibliothequeWebApplicationController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
