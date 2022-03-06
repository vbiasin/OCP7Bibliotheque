package com.ocp7bibliotheque.bibliothequeweb.Controllers;

import com.ocp7bibliotheque.bibliothequeweb.Entites.UserAccount;
import com.ocp7bibliotheque.bibliothequeweb.Proxies.BibliothequeAdministrationUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class WebUserAccountController {

    @Autowired
    private BibliothequeAdministrationUserProxy userProxy;

    @GetMapping("/")
    public String start() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/inscription")
    public String inscription() {
        return "inscription";
    }

    @PostMapping("/inscription")
    public String inscriptionForm( String mail, String password) {
        UserAccount userAccount = new UserAccount(mail,password);
        UserAccount userAccountSaved = userProxy.registerUser(userAccount);
        return "inscriptionResult";
    }

}
