package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
