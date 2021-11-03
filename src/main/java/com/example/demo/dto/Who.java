package com.example.demo.dto;

import javax.validation.constraints.Size;

public class Who {
    private String name;
    @Size(min=4, max=20, message = "Der Name muss zwischen 4 und 20 Stellen lang sein!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
