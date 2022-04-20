package com.ocp7bibliotheque.bibliothequebook.DAO;

import com.ocp7bibliotheque.bibliothequebook.Entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findById(int idBook);
    public List<Book> findByTitleContainsOrAuthorContains(String title, String author);

}
