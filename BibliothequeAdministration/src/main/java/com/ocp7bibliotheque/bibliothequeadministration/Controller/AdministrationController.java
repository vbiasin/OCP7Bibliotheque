package com.ocp7bibliotheque.bibliothequeadministration.Controller;


import com.ocp7bibliotheque.bibliothequeadministration.DTO.RoleDTO;
import com.ocp7bibliotheque.bibliothequeadministration.DTO.UserAccountDTO;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import com.ocp7bibliotheque.bibliothequeadministration.Services.ILibraryService;
import com.ocp7bibliotheque.bibliothequeadministration.Services.IRoleService;
import com.ocp7bibliotheque.bibliothequeadministration.Services.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AdministrationController {

    @Autowired
    private  ILibraryService libraryService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserAccountService userAccountService;



    @PostMapping("/addLibraryBack")
    public ResponseEntity<Library> addLibrary(@RequestBody Library library) throws Exception {
        try {
            return new ResponseEntity<Library>(libraryService.addLibrary(library), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addRoleBack")
    public ResponseEntity<String> addRole(@RequestBody RoleDTO roleDTO) throws Exception {
        try {
            roleService.addRoleToUserAccount(roleDTO.getMail(),roleDTO.getIdRole());
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/searchUserAccountBack")
    public ResponseEntity<Page<UserAccount>> searchUserAccount(@RequestBody UserAccountDTO userAccountDTO) throws Exception {
        try {
            return new ResponseEntity<>(userAccountService.searchUserAccount(userAccountDTO.getMail(),userAccountDTO.getLastName(), userAccountDTO.getFirstName(),userAccountDTO.getPages(),userAccountDTO.getSize()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/removeRoleBack")
    public ResponseEntity<String> removeRole(@RequestBody RoleDTO roleDTO) throws Exception {
        try {
            roleService.removeRoleFromUserAccount(roleDTO.getMail(),roleDTO.getIdRole());
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
