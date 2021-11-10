package com.example.demo.controller;

import com.example.demo.dto.Greeting;
import com.example.demo.dto.Who;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*    ;

@Controller
public class TwitterController {
    @GetMapping("/addTweet")
    public String addTweet(Model model){
        model.addAttribute("addTweet", true);
        return "greeting";
    }

    @PostMapping("/sendTweet")
    public String postInput(@RequestParam String author, @RequestParam String tweet, @RequestParam String content, Model model){
        model.addAttribute("author", "");
        model.addAttribute("tweet", "");
        return "greeting";
    }

}
