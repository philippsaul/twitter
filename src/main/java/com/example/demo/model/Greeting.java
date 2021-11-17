package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Greeting {

    private long id;
    private String name;
    private String phrase;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public long getId() {
        return id;
    }

    @Column(length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Column(length = 200, nullable = false)
    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
