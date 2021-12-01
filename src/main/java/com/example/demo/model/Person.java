package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Person extends MyBaseEntity{

    private long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_gen")
    @SequenceGenerator(name = "person_gen", sequenceName = "person_seq", allocationSize = 1)
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

}
