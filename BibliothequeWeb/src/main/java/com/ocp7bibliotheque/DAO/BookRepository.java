package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
