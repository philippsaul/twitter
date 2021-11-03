package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class FH2021RestController {
    // @RequestMapping(path="/hallo", method = RequestMethod.GET)
    @GetMapping("/hallo")
    public String hallo(){
        return "Hallo";
    }

    @GetMapping("/hallo/query")
    public String halloQuery(@RequestParam(required = false, defaultValue = "Manfred") String name){
        return "<h1>Hallo "+name+"</h1>";
    }

    @GetMapping("/hallo/path/{name}")
    public String halloQueryPath(@PathVariable String name){
        return "<h1>Hallo "+name+"</h1>";
    }

    @PostMapping("/hallo/body")
    public String postTest(@RequestBody String name){
        return "<h1>Hallo "+name+"</h1>";
    }

    @PostMapping("/hallo/dto")
    public String postTest2(@RequestBody Who who){
        return "<h1>Hallo "+who.getName()+"</h1>";
    }

    @PostMapping("/hallo/dto2")
    public Greeting postTest3(@RequestBody Who who){
        Greeting greeting = new Greeting();
        greeting.setName("Hallo"+who.getName());
        return greeting;
    }

    @PostMapping("/hallo/dto3")
    public ResponseEntity<Greeting> postTest4(@RequestBody Who who){
        Greeting greeting = new Greeting();
        greeting.setName("Hallo"+who.getName());
        //return ResponseEntity.ok(greeting);
        return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body(greeting);
    }

    @PostMapping(value="/hallo/dto4", produces = "application/xml")
    public ResponseEntity<Greeting> postTest5(@RequestBody Who who){
        Greeting greeting = new Greeting();
        greeting.setName("Hallo"+who.getName());
        //return ResponseEntity.ok(greeting);
        return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body(greeting);
    }
}
