package com.ocp7bibliotheque.bibliothequeweb.DAO;

import com.ocp7bibliotheque.bibliothequeweb.Entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
    public List<UserAccount> findAllByIsActive(boolean check);
}
