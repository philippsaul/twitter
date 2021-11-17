package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @PostMapping("/add")
    public int postAddTwoIntegers(@RequestParam int one, @RequestParam int two){
        int three = one + two;
        return three;
    }
}
