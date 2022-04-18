package com.ocp7bibliotheque.bibliothequeweb.Controllers;
import com.ocp7bibliotheque.bibliothequeweb.DTO.BookDTo;
import com.ocp7bibliotheque.bibliothequeweb.Entites.Book;
import com.ocp7bibliotheque.bibliothequeweb.Proxies.BibliothequeBookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class WebBookController {

    @Autowired
    private BibliothequeBookProxy bookProxy;

    @GetMapping("/books")
    public String book() {
        return "book";
    }

    @PostMapping("/addBook")
    public String book(String resume, String title, String author, int numberExemplar, int idLibrary) {
        Book book = new Book(new Date(),resume,title,author,numberExemplar);
        BookDTo bookDTO = new BookDTo(idLibrary, book);
        bookProxy.addBook(bookDTO);
        return  "book";
    }

}
