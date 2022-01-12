package com.ocp7bibliotheque.bibliothequeweb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebAdministrationController {

    @GetMapping("/administration")
    public String administration() {
        return "administration";
    }
}
