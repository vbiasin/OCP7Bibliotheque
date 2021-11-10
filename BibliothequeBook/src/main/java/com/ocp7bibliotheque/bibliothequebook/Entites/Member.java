package com.ocp7bibliotheque.bibliothequebook.Entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date signInDate;
    @OneToOne
    private Contact contact;
    @OneToOne
    private UserAccount userAccount;

    public Member() {
        this.signInDate = new Date();
    }

    public Member(Contact contact, UserAccount userAccount) {
        this.signInDate = new Date();
        this.contact = contact;
        this.userAccount = userAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSignInDate() {
        return signInDate;
    }

    public void setSignInDate(Date signInDate) {
        this.signInDate = signInDate;
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
