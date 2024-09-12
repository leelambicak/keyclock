package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Title {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String authorNamme;
    public Title(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthorNamme() {
        return authorNamme;
    }
    public void setAuthorNamme(String authorNamme) {
        this.authorNamme = authorNamme;
    }
    public Title(int id, String name, String authorNamme) {
        this.id = id;
        this.name = name;
        this.authorNamme = authorNamme;
    }

    
}
