package com.ocp7bibliotheque.bibliothequeweb.DTO;

import java.io.Serializable;

public class LibraryDTO implements Serializable {

    private String name;
    private String address;
    private int pages;
    private int size;

    public LibraryDTO(String name, String address, int pages, int size) {
        this.name = name;
        this.address = address;
        this.pages = pages;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
