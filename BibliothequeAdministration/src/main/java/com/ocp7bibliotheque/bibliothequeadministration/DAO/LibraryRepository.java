package com.ocp7bibliotheque.bibliothequeadministration.DAO;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library,Integer> {

    public Optional<Library> findById(int id);
    public Optional<Library> findByNameAndAddress(String name, String address);
}
