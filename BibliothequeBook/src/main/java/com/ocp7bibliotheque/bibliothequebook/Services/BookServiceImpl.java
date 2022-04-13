package com.ocp7bibliotheque.bibliothequebook.Services;

import com.ocp7bibliotheque.bibliothequebook.DAO.BookRepository;
import com.ocp7bibliotheque.bibliothequebook.DAO.LibraryRepository;
import com.ocp7bibliotheque.bibliothequebook.Entites.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void removeBook(int idBook) throws Exception {

    }

    @Override
    public Book addBook(Book book) throws Exception {
        return null;
    }

    @Override
    public Book modifyBook(Book book) throws Exception {
        return null;
    }

    @Override
    public Page<Book> searchBook(String name, String author, int pages, int size) throws Exception {
        return null;
    }
}
