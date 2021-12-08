package com.example.demo.service.impl;

import com.example.demo.model.Person;
import com.example.demo.repository.GreetingRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Greeting;

import java.util.Optional;


@Service
public class SimpleServiceImpl implements SimpleService {
    private final GreetingRepository greetingRepository;
    private final PersonRepository personRepository;

    @Autowired
    public SimpleServiceImpl(GreetingRepository greetingRepository, PersonRepository personRepository) {
        this.greetingRepository = greetingRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void createAndSaveGreeting(String name){
        Person person = personRepository.findByName(name).orElseGet(() -> {
                Person newPerson = new Person();
                newPerson.setName(name);
                return personRepository.save(newPerson);
        });

        Greeting greeting = new Greeting();
        greeting.setPerson(person);
        greeting.setPhrase("Hallo         " + name);
        greetingRepository.save(greeting);
    }
}