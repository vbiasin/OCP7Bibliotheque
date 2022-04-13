package com.ocp7bibliotheque.bibliothequeweb.Proxies;

import com.ocp7bibliotheque.bibliothequeweb.DTO.ContactDTO;
import com.ocp7bibliotheque.bibliothequeweb.DTO.LibraryDTO;
import com.ocp7bibliotheque.bibliothequeweb.DTO.RoleDTO;
import com.ocp7bibliotheque.bibliothequeweb.DTO.UserAccountDTO;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Contact;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Library;
import com.ocp7bibliotheque.bibliothequeweb.Entites.UserAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "BibliothequeAdministration", url = "localhost:8280")
public interface BibliothequeAdministrationUserProxy {
    @PostMapping(value = "/register")
    UserAccount registerUser(@RequestBody UserAccount userAccount);

    @PostMapping(value = "/loginBack")
    Boolean login(@RequestBody UserAccount userAccount);

    @PostMapping(value = "/addContactBack")
    Contact addContact(@RequestBody ContactDTO contactDTO);

    @PostMapping(value = "/addLibraryBack")
    Library addLibrary(@RequestBody Library library);

    @PostMapping(value = "/addRoleBack")
    void addRole(@RequestBody RoleDTO roleDTO);

    @PostMapping(value = "/searchUserAccountBack")
    Page<UserAccount> searchUserAccount(@RequestBody UserAccountDTO userAccountDTO);

    @PostMapping(value = "/removeRoleBack")
    void removeRole(@RequestBody RoleDTO roleDTO);

    @PostMapping(value = "/searchLibraryBack")
    Page<Library> searchLibrary(@RequestBody LibraryDTO libraryDTO);

    @PostMapping(value = "/removeUserAccountBack")
    void removeUserAccount(@RequestBody int idUserAccount);


}
