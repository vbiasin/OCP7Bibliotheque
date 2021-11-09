package com.ocp7bibliotheque.bibliothequeweb.DAO;

import com.ocp7bibliotheque.bibliothequeweb.Entites.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Integer>{
}
