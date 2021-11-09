package com.ocp7bibliotheque.bibliothequeweb.DAO;

import com.ocp7bibliotheque.bibliothequeweb.Entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
