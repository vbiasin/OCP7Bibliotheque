package com.ocp7bibliotheque.bibliothequeadministration.DAO;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library,Integer> {

    public Optional<Library> findById(int id);
    public List<Library> findByNameContainsOrAddressContains(String name, String address);
    public Optional<Library>findByNameAndAddress(String name, String address);

}
