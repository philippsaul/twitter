package com.example.demo.service.impl;

import com.example.demo.repository.GreetingRepository;
import com.example.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Greeting;
import com.example.demo.service.SimpleService;


@Service
public class SimpleServiceImpl implements SimpleService {
    private final GreetingRepository greetingRepository;

    @Autowired
    public SimpleServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void createAndSaveGreeting(String name) {
/**        Greeting greeting = new Greeting();
        greeting.setName(name);
        greeting.setPhrase("hallo"+ name);
        greetingRepository.save(greeting);**/
    }
}