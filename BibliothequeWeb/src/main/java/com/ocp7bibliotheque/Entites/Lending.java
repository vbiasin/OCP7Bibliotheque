package com.ocp7bibliotheque.Entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Lending implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    @OneToOne
    private UserAccount userAccount;
    @OneToMany(mappedBy="lending",fetch=FetchType.LAZY)
    private Collection<Book> books;

    public Lending() {
    }

    public Lending(String status, UserAccount userAccount, Collection<Book> books) {
        this.status = status;
        this.userAccount = userAccount;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
