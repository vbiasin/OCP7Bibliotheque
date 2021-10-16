package com.ocp7bibliotheque.Entites;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String secuNumber;
    private double salary;
    @OneToOne
    private Contact contact;
    @OneToOne
    private UserAccount userAccount;

    public Employee() {
    }

    public Employee(String secuNumber, double salary) {
        this.secuNumber = secuNumber;
        this.salary = salary;
    }

    public Employee(String secuNumber, double salary, Contact contact, UserAccount userAccount) {
        this.secuNumber = secuNumber;
        this.salary = salary;
        this.contact = contact;
        this.userAccount = userAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecuNumber() {
        return secuNumber;
    }

    public void setSecuNumber(String secuNumber) {
        this.secuNumber = secuNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
