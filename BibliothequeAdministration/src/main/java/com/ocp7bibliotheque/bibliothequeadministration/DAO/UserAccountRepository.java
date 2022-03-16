package com.ocp7bibliotheque.bibliothequeadministration.DAO;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    public Optional<UserAccount> findByMail(String mail);
    public Optional<UserAccount> findByMailAndPassword(String mail, String password);
    @Query("SELECT user from UserAccount user where (:mail is null or LOWER(user.mail) LIKE %:mail%) "
            + "or (:lastName is null or LOWER(user.contact.lastName) LIKE %:lastName%)"
            +"or (:firstName is null or LOWER(user.contact.firstName) LIKE %:firstName%)")

    public Page<UserAccount> searchUserAccount(@Param("mail")String mail, @Param("lastName")String lastName, @Param("firstName") String firstname, Pageable pageable);
}
