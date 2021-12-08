package com.example.demo.controller;

import com.example.demo.dto.Tweet;
import com.example.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;
import com.example.demo.service.impl.SaveServiceImpl;
import java.util.List;

@Controller
@RequestMapping("/xxx")
public class TwitterController {

    private final SaveServiceImpl saveServiceImpl;
    private final SimpleService simpleService;

    @Autowired
    public TwitterController(SaveServiceImpl saveServiceImpl, SimpleService simpleService){
        this.saveServiceImpl = saveServiceImpl;
        this.simpleService = simpleService;
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
        simpleService.createAndSaveGreeting(tweet.getAuthor());

        return "redirect:/";
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
