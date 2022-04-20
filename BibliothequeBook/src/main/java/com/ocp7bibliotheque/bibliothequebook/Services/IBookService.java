package com.ocp7bibliotheque.bibliothequebook.Services;

import com.ocp7bibliotheque.bibliothequebook.Entites.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    public void removeBook(int idBook) throws Exception;
    public Book addBook(int idLibrary,Book book) throws Exception;
    public Book modifyBook(int idBook, int numberExemplar) throws Exception;
    public Page<Book> searchBook(String name, String author, int pages, int size) throws Exception;
}
