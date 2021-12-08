package com.ocp7bibliotheque.bibliothequeadministration.DAO;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    public Optional<UserAccount> findByMail(String mail);
    public Optional<UserAccount> findByMailAndPassword(String mail, String password);
}
