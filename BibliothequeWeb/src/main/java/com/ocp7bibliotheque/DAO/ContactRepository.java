package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
