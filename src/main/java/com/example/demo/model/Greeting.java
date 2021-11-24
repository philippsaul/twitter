package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Greeting {

    private long id;
    private String name;
    private String phrase;
    private LocalDateTime created;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "greeting_gen")
    @SequenceGenerator(name = "greeting_gen", sequenceName = "greeting_seq", allocationSize = 1)
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

    @PrePersist
    public void calculateCreated(){created= LocalDateTime.now();}
}
