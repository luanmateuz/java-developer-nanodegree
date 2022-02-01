package com.udacity.sdj.runner;

import com.udacity.sdj.entity.Person;
import com.udacity.sdj.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Command implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        Person person1 = new Person("Maria");
        Person person2 = new Person("Bob");
        Person person3 = new Person("John");

        // persist
        personRepository.saveAll(List.of(person1, person2, person3));

        // find
        personRepository.findById(5L).ifPresent(System.out::println);
    }
}
