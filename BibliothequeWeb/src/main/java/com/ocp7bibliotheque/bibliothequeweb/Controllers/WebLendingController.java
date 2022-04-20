package com.ocp7bibliotheque.bibliothequeweb.Controllers;

import com.ocp7bibliotheque.bibliothequeweb.Proxies.BibliothequeBookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebLendingController {

    @Autowired
    private BibliothequeBookProxy bookProxy;

    @GetMapping("/loan")
    public String book() {
        return "loan";
    }

}
