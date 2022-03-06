package com.ocp7bibliotheque.bibliothequeweb.Controllers;

import com.ocp7bibliotheque.bibliothequeweb.DTO.ContactDTO;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Contact;
import com.ocp7bibliotheque.bibliothequeweb.Proxies.BibliothequeAdministrationUserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebContactController {

    @Autowired
    private BibliothequeAdministrationUserProxy userProxy;




    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/addContact")
    public String contact(String lastName, String firstName, String address) {
        Contact contact = new Contact(lastName, firstName, address);
        UserDetails activeUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ContactDTO contactDTO = new ContactDTO(activeUser.getUsername(),contact);
        Contact contactSaved = userProxy.addContact(contactDTO);
        return  "contact";
    }
}
