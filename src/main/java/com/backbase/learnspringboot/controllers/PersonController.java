package com.backbase.learnspringboot.controllers;

import com.backbase.learnspringboot.entity.Person;
import com.backbase.learnspringboot.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
        Person personResponse = personService.addNewPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personService.getAllPersons();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PutMapping("/{id}") //When complete object values are going to change
    public ResponseEntity<Person> updatePeople(@PathVariable("id") Long id, @RequestBody Person person) {
        try {
            Person people = personService.updatePerson(id, person);
            return new ResponseEntity<>(people, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Person(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping() //When only few attributes has to be changed
    public ResponseEntity<List<Person>> patchPeopleData() {
        List<Person> people = personService.getAllPersons();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable("id") Long id) {
        boolean response = personService.deletePerson(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
