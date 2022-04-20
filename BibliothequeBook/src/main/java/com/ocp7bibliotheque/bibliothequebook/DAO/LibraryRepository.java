package com.ocp7bibliotheque.bibliothequebook.DAO;

import com.ocp7bibliotheque.bibliothequebook.Entites.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library,Integer>{

    Optional<Library> findById(int idLibrary) throws Exception;

}
