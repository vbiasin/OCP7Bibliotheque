package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Integer>{
}
