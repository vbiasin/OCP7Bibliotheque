package com.ocp7bibliotheque.bibliothequeadministration.DAO;


import com.ocp7bibliotheque.bibliothequeadministration.Entites.Book;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findByLibrary(Library library);

}
