package com.ocp7bibliotheque.bibliothequebook.Services;

import com.ocp7bibliotheque.bibliothequebook.DAO.BookRepository;
import com.ocp7bibliotheque.bibliothequebook.DAO.LibraryRepository;
import com.ocp7bibliotheque.bibliothequebook.Entites.Book;
import com.ocp7bibliotheque.bibliothequebook.Entites.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void removeBook(int idBook) throws Exception {
        Optional<Book> book = bookRepository.findById(idBook);
        if(book.isEmpty()) throw new Exception ("Ce livre n'existe pas !");
        bookRepository.delete(book.get());
    }

    @Override
    public Book addBook(int idLibrary, Book book) throws Exception {
        Optional<Library> library = libraryRepository.findById(idLibrary);
        if (library.isEmpty()) throw new Exception ("Cette Bibliotheque n'existe pas.");
        if (book.getNumberExemplar()<=0) throw new Exception("Le nombre d'exemplaires ne peut être nul ou négatif !");
        book.setLibrary(library.get());
        return bookRepository.save(book);
    }

    @Override
    public Book modifyBook(int idBook, int numberExemplar) throws Exception {
        Optional<Book> book = bookRepository.findById(idBook);
        if(book.isEmpty()) throw new Exception ("Ce livre n'existe pas !");
        if(numberExemplar<=0) throw new Exception("Le nombre d'exemplaires ne peut être nul ou négatif !");
        book.get().setNumberExemplar(numberExemplar);
        return bookRepository.saveAndFlush(book.get());
    }

    @Override
    public Page<Book> searchBook(String title, String author, int pages, int size) throws Exception {
        List<Book> books = bookRepository.findByTitleContainsOrAuthorContains(title,author);
        List<Book> noDoublonBooks = new ArrayList<>();
        if(!books.isEmpty()){
            for( Book book:  books ){
                if(noDoublonBooks.isEmpty()) noDoublonBooks.add(book);
                boolean doublon = true;
                for (Book noDoublonBook:noDoublonBooks) {
                    if (!book.getTitle().equals(noDoublonBook.getTitle()) || !book.getAuthor().equals(noDoublonBook.getAuthor())){
                        doublon=false;
                    }
                }
                if (!doublon) noDoublonBooks.add(book);
            }
        }
        else noDoublonBooks = bookRepository.findAll();

        Pageable pageable = PageRequest.of(0, size);

        Page<Book> resultPage = new PageImpl<>(noDoublonBooks, pageable, (noDoublonBooks.size())%size);

        return resultPage;
    }
}
