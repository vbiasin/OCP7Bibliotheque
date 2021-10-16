package com.ocp7bibliotheque.Entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "books")
    private Collection<Library> libraries;
    private Boolean isAvailable;
    private Date publicationDate;
    private String resume;
    private String title;
    private String author;
    private int numberExemplar;
    @ManyToOne (fetch=FetchType.LAZY)
    private Lending lending;

    public Book() {
    }

    public Book(Date publicationDate, String resume, String title, String author, int numberExemplar) {
        this.isAvailable = true;
        this.publicationDate = publicationDate;
        this.resume = resume;
        this.title = title;
        this.author = author;
        this.numberExemplar = numberExemplar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Collection<Library> libraries) {
        this.libraries = libraries;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberExemplar() {
        return numberExemplar;
    }

    public void setNumberExemplar(int numberExemplar) {
        this.numberExemplar = numberExemplar;
    }
}
