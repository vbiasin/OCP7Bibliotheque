package com.ocp7bibliotheque.bibliothequeadministration.DAO;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Optional<Role> findById(int id);
    public Optional<Role> findByName(String name);

}
