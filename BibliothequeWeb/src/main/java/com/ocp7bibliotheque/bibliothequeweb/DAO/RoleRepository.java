package com.ocp7bibliotheque.bibliothequeweb.DAO;

import com.ocp7bibliotheque.bibliothequeweb.Entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
