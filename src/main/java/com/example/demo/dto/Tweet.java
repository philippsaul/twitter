package com.example.demo.dto;

public class Tweet {
    private String text;
    private String author;

    public Tweet(String author, String tweet){
        this.author = author;
        this.text = tweet;
    }
    public Tweet(){
       this.text = "";
        this.author = "";
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
