package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
    public List<UserAccount> findAllByIsActive(boolean check);
}
