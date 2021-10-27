package com.ocp7bibliotheque.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BibliothequeWebApplicationController {

    @RequestMapping("/")
    public String login() {
        return "login";
    }

}
