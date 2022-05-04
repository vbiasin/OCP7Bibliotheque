package com.ocp7bibliotheque.bibliothequebook.Controller;


import com.ocp7bibliotheque.bibliothequebook.DTO.LendingDTO;
import com.ocp7bibliotheque.bibliothequebook.Entites.Lending;
import com.ocp7bibliotheque.bibliothequebook.Services.ILendingService;
import com.ocp7bibliotheque.bibliothequebook.Services.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LendingController {

    @Autowired
    private IUserAccountService userAccountService;

    @Autowired
    private ILendingService lendingService;

    @GetMapping("/loansBack")
    public ResponseEntity<Boolean> checkActiveUserContact(@RequestParam("activeUsername")  String activeUserName) throws Exception {
        try {
            return new ResponseEntity<Boolean>(userAccountService.checkUserAccountContact(activeUserName), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/borrowBack")
    public ResponseEntity<Lending> borrow(@RequestBody LendingDTO lendingDTO) throws Exception {
        try {
            return new ResponseEntity<>(lendingService.borrow(lendingDTO.getMail(),lendingDTO.getIdBook()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/extendLoanBack")
    public ResponseEntity<Lending> extendLoan(@RequestBody int idLending) throws Exception {
        try {
            return new ResponseEntity<>(lendingService.extendLoan(idLending), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/displayLoansBack")
    public ResponseEntity<List<Lending>> displayLoans(@RequestParam("activeUsername")  String activeUserName) throws Exception {
        try {
            return new ResponseEntity<>(lendingService.displayLoan(activeUserName), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
