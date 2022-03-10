package com.ocp7bibliotheque.bibliothequebook.DTO;

public class UserAccountDTO {

    private String mail;
    private String lastName;
    private String firstName;
    private int pages;
    private int size;

    public UserAccountDTO(String mail, String lastName, String firstName, int pages, int size) {
        this.mail = mail;
        this.lastName = lastName;
        this.firstName = firstName;
        this.pages = pages;
        this.size = size;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}