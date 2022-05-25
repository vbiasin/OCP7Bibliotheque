package com.ocp7bibliotheque.bibliothequebatchmail.DAO;



import com.ocp7bibliotheque.bibliothequebatchmail.Entites.Lending;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending,Integer> {


}
