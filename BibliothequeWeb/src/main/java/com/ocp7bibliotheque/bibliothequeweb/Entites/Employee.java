package com.ocp7bibliotheque.bibliothequeweb.Entites;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee  extends UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employeeCode;
    private double salary;


    public Employee() {
    }

    public Employee(String employeeCode, double salary) {
        this.employeeCode = employeeCode;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}