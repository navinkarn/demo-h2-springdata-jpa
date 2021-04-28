package com.parameterizedtest.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity //indicates that it is a JPA entity,no @Table annotation exists, it is assumed that this entity is mapped to a table Book
@Table(name="BOOK_TBL")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //id should be generated automatically
    private int id;
    private String name;
    private String publication;

    //default constructor is for sake of JPA
    public Book() {
    }



    public Book(String name, String publication) {
        this.name = name;
        this.publication = publication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publication='" + publication + '\'' +
                '}';
    }
}
