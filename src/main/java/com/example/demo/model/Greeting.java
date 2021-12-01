package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Greeting extends MyBaseEntity {

    private long id;
    private String phrase;
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "greeting_gen")
    @SequenceGenerator(name = "greeting_gen", sequenceName = "greeting_seq", allocationSize = 1)
    @Column(nullable = false)
    public long getId() {
        return id;
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

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
