package com.example.demo.controller;

import com.example.demo.dto.Greeting;
import com.example.demo.dto.Tweet;
import com.example.demo.dto.Who;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;
import com.example.demo.service.impl.SaveServiceImpl;
import java.util.List;

@Controller
public class TwitterController {

    private final SaveServiceImpl saveServiceImpl;

    @Autowired
    public TwitterController(SaveServiceImpl saveServiceImpl){
        this.saveServiceImpl = saveServiceImpl;
    }

    @GetMapping("/")
    public String greet(Model model){
        Tweet tweet = new Tweet();
        List<Tweet> tweets = saveServiceImpl.getAllTweets();
        model.addAttribute("tweet_content","Dies ist ein toller Tweet.");
        model.addAttribute("author","Chef");
        model.addAttribute("addTweet", false);

        model.addAttribute("tweet", tweet);
        model.addAttribute("tweets", tweets);
        return "greeting";
    }


    @PostMapping("/sendTweet")
    public String sendTweet(Tweet tweet, @RequestParam String author, @RequestParam String tweetcontent, Model model){
        model.addAttribute("addTweet", false);
        saveServiceImpl.addTweet(new Tweet(tweet.getAuthor(), tweet.getText()));
        return "greeting";
    }

    @GetMapping("/addTweet")
    public String addTweet(Model model){
        model.addAttribute("addTweet", true);
        return "greeting";
    }

    /*@PostMapping("/sendTweet")
    public String postInput(@RequestParam String author, @RequestParam String tweet, @RequestParam String content, Model model){
        model.addAttribute("author", "");
        model.addAttribute("tweet", "");
        return "greeting";
    }*/

}
