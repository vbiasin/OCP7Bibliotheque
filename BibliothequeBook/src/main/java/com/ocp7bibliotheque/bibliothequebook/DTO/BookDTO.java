package com.ocp7bibliotheque.bibliothequebook.DTO;

import com.ocp7bibliotheque.bibliothequebook.Entites.Book;

import java.io.Serializable;

public class BookDTO implements Serializable {

    private int idLibrary;
    private Book book;

    public BookDTO() {
    }

    public BookDTO(int idLibrary, Book book) {
        this.idLibrary = idLibrary;
        this.book = book;
    }

    public int getIdLibrary() {
        return idLibrary;
    }

    public void setIdLibrary(int idLibrary) {
        this.idLibrary = idLibrary;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
