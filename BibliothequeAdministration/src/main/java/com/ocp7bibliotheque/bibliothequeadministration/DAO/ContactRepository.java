package com.ocp7bibliotheque.bibliothequeadministration.DAO;


import com.ocp7bibliotheque.bibliothequeadministration.Entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}