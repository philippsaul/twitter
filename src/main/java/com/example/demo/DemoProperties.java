package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties("demo")
public class DemoProperties {
    private String bla = "hi";

    public String getBla() {
        return bla;
    }

    public void setBla(String bla) {
        this.bla = bla;
    }
}
