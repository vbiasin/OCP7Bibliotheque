package com.ocp7bibliotheque.DAO;

import com.ocp7bibliotheque.Entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
