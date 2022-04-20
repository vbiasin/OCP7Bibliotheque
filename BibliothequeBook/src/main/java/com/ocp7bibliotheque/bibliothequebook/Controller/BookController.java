package com.ocp7bibliotheque.bibliothequebook.Controller;

import com.ocp7bibliotheque.bibliothequebook.DTO.BookDTO;
import com.ocp7bibliotheque.bibliothequebook.Entites.Book;
import com.ocp7bibliotheque.bibliothequebook.Services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private IBookService bookService;


    @PostMapping("/addBookBack")
    public ResponseEntity<Book> addContact(@RequestBody BookDTO bookDTO) throws Exception {
        try {
            return new ResponseEntity<>(bookService.addBook(bookDTO.getIdLibrary(),bookDTO.getBook()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/modifyBookBack")
    public ResponseEntity<String>modifyBook(@RequestBody BookDTO bookDTO) throws Exception {
        try {
            bookService.modifyBook(bookDTO.getIdBook(), bookDTO.getNumberExemplar());
            return new ResponseEntity<String>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/removeBookBack")
    public ResponseEntity<String>removeBook(@RequestBody int idBook) throws Exception {
        try {
            bookService.removeBook(idBook);
            return new ResponseEntity<String>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/searchLibraryBack")
    public ResponseEntity<Page<Book>> searchLibrary(@RequestBody BookDTO bookDTO) throws Exception {
        try {
            return new ResponseEntity<>(bookService.searchBook(bookDTO.getTitle(),bookDTO.getAuthor(),bookDTO.getPages(),bookDTO.getSize()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
