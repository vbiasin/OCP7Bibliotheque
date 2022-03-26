package com.ocp7bibliotheque.bibliothequeadministration.DAO;


import com.ocp7bibliotheque.bibliothequeadministration.Entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    public List<Contact> findByLastNameOrFirstName(String lastName, String firstName);

}
