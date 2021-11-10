package com.example.demo.service.impl;

import com.example.demo.dto.Tweet;
import com.example.demo.service.SaveService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaveServiceImpl implements SaveService {
    private final List<Tweet> tweets;
    public SaveServiceImpl(){
        tweets = new ArrayList<>();
        tweets.add(new Tweet("Hans", "Trinke gerade Kaffee"));

    }
    @Override
    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }
    @Override
    public List<Tweet> getAllTweets(){
        return new ArrayList<>(tweets);
    }
}
