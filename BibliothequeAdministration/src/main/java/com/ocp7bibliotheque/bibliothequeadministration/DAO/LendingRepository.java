package com.ocp7bibliotheque.bibliothequeadministration.DAO;


import com.ocp7bibliotheque.bibliothequeadministration.Entites.Lending;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LendingRepository extends JpaRepository<Lending,Integer> {

    List<Lending> findByUserAccount(UserAccount userAccount) throws Exception;
}
