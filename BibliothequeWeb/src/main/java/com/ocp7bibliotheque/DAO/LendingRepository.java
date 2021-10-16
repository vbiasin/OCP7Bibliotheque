package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending,Integer>{
}
