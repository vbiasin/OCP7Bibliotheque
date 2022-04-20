package com.ocp7bibliotheque.bibliothequeweb.Proxies;


import com.ocp7bibliotheque.bibliothequeweb.Entites.Book;
import com.ocp7bibliotheque.bibliothequeweb.DTO.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    Page<Book> searchBook(@RequestBody BookDTO bookDTO);

    @GetMapping(value="/lendingBack")
    Boolean getLendingPage(String activeUsername);
}
