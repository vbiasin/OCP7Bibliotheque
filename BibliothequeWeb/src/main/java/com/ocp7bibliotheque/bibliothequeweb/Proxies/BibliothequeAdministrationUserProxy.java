package com.ocp7bibliotheque.bibliothequeweb.Proxies;

import com.ocp7bibliotheque.bibliothequeweb.Entites.UserAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "BibliothequeAdministration", url = "localhost:8280")
public interface BibliothequeAdministrationUserProxy {
    @PostMapping(value = "/register")
    UserAccount registerUser(@RequestBody UserAccount userAccount);
    @PostMapping(value = "/loginBack")
    Boolean gogo(@RequestBody UserAccount userAccount);
}
