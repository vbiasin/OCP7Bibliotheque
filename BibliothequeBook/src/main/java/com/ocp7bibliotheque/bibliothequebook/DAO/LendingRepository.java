package com.ocp7bibliotheque.bibliothequebook.DAO;

import com.ocp7bibliotheque.bibliothequebook.Entites.Lending;
import com.ocp7bibliotheque.bibliothequebook.Entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LendingRepository extends JpaRepository<Lending,Integer> {

    Optional<Lending> findById(int idLending) throws Exception;
    List<Lending> findByUserAccount(UserAccount userAccount) throws Exception;
}
