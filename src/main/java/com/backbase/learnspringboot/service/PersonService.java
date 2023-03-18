package com.backbase.learnspringboot.service;

import com.backbase.learnspringboot.entity.Person;

import java.util.List;

public interface PersonService {
    Person addNewPerson(Person person); // Create
    Person updatePerson(Long id , Person person) throws Exception; // Update

    List<Person> getAllPersons(); //Retrive
    boolean deletePerson(Long id); //Delete

}
