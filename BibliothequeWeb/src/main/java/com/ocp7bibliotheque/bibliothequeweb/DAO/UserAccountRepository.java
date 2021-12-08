package com.ocp7bibliotheque.bibliothequeweb.DAO;

import com.ocp7bibliotheque.bibliothequeweb.Entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
    public Optional<UserAccount> findByMail(String mail);

}
