package com.example.demo.service;

import com.example.demo.dto.Tweet;
import java.util.List;

public interface SaveService {
    void addTweet(Tweet tweet);
    List<Tweet> getAllTweets();
}
