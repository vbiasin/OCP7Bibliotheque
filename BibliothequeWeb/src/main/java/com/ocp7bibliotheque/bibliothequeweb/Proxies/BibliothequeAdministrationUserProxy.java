package com.ocp7bibliotheque.bibliothequeweb.Proxies;

import com.ocp7bibliotheque.bibliothequeweb.DTO.ContactDTO;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Contact;
import com.ocp7bibliotheque.bibliothequeweb.Entites.UserAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BibliothequeAdministration", url = "localhost:8280")
public interface BibliothequeAdministrationUserProxy {
    @PostMapping(value = "/register")
    UserAccount registerUser(@RequestBody UserAccount userAccount);
    @PostMapping(value = "/loginBack")
    Boolean login(@RequestBody UserAccount userAccount);
    @PostMapping(value = "/addContactBack")
   Contact addContact(@RequestBody ContactDTO contactDTO);

}
