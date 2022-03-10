package com.ocp7bibliotheque.bibliothequeadministration.Controller;

import com.ocp7bibliotheque.bibliothequeadministration.DTO.ContactDTO;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Contact;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import com.ocp7bibliotheque.bibliothequeadministration.Services.IContactService;
import com.ocp7bibliotheque.bibliothequeadministration.Services.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private IContactService contactService;

    @Autowired
    private IUserAccountService userAccountService;


    @PostMapping("/addContactBack")
    public ResponseEntity<Contact> addContact(@RequestBody ContactDTO contactDTO) throws Exception {
        UserAccount userAccount = userAccountService.getUserAccount(contactDTO.getMail());
        try {
            return new ResponseEntity<>(contactService.addContact(userAccount.getId(), contactDTO.getContact()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
