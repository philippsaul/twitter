package com.example.demo.controller;

import com.example.demo.dto.Who;
import com.example.demo.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TLController {

    private final SaveService saveService;

    @Autowired
    public TLController(SaveService saveService){
        this.saveService = saveService;
    }

    @GetMapping("/greet")
    public String greet(Model model){
        model.addAttribute("name","Herbert");
        return "greeting";
    }

    @GetMapping("/input")
    public String getInput(){
        return "input";
    }

    @PostMapping("/input")
    public String postInput(@RequestParam String name, Model model){
        model.addAttribute("greeting", "Hallo "+name);
        return "input";
    }
    @GetMapping("/binding")
    public String getBinding(Model model){
        Who who = new Who();
        model.addAttribute("who", who);
        return "binding";
    }

    @PostMapping("/binding")
    public String postBinding(@Valid Who who, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("greeting", "Vollidiot, falsche Stellenlänge!");
            return "binding";
        }
        model.addAttribute("greeting", "Hallo "+who.getName());
        return "binding";
    }
}
