package com.backbase.learnspringboot.controllers;

import com.backbase.learnspringboot.entity.Person;
import com.backbase.learnspringboot.service.PersonService;
import com.backbase.learnspringboot.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @PostMapping()
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person){
        Person personResponse  = personService.addNewPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAllPeople(){
        List<Person> people = personService.getAllPersons();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable("id") Long id){
        boolean response =  personService.deletePerson(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
