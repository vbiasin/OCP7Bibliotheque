package com.ocp7bibliotheque.bibliothequebook.DAO;

import com.ocp7bibliotheque.bibliothequebook.Entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {

    Optional<UserAccount> findByMail(String mail);

}
