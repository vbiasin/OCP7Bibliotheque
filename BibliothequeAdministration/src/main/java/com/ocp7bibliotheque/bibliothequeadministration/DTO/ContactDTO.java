package com.ocp7bibliotheque.bibliothequeadministration.DTO;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.Contact;

import java.io.Serializable;

public class ContactDTO implements Serializable {

    private String mail;
    private Contact contact;

    public ContactDTO() {
    }

    public ContactDTO(String mail, Contact contact) {
        this.mail = mail;
        this.contact = contact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

