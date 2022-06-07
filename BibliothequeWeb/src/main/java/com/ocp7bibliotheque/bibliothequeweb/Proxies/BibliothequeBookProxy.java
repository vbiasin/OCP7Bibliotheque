package com.ocp7bibliotheque.bibliothequeweb.Proxies;


import com.ocp7bibliotheque.bibliothequeweb.DTO.LendingDTO;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Book;
import com.ocp7bibliotheque.bibliothequeweb.DTO.BookDTO;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Lending;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "BibliothequeBook", url = "localhost:8180")
public interface BibliothequeBookProxy {

    @GetMapping(value="/booksBack")
    Boolean getBookPage(@RequestParam("activeUsername")  String activeUsername);

    @PostMapping(value = "/addBookBack")
    Book addBook(@RequestBody BookDTO bookDTO);

    @PostMapping(value = "/modifyBookBack")
    Book modifyBook(@RequestBody BookDTO bookDTO);

    @PostMapping(value = "/removeBookBack")
    void removeBook(@RequestBody int idBook);

    @PostMapping(value = "/searchBookBack")
    List<Book> searchBook(@RequestBody BookDTO bookDTO);

    @GetMapping(value="/loansBack")
    Boolean getLendingPage(@RequestParam("activeUsername")String activeUsername);

    @PostMapping(value = "/borrowBack")
    Book borrow(@RequestBody LendingDTO lendingDTO);

    @PostMapping(value = "/extendLoanBack")
    Lending extendLoan(@RequestBody int idLending);

    @GetMapping(value="/displayLoansBack")
    List<Lending> displayLoans(@RequestParam("activeUsername") String activeUsername);
}
