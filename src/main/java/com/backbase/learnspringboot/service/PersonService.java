package com.backbase.learnspringboot.service;

import com.backbase.learnspringboot.entity.Person;

import java.util.List;

public interface PersonService {
    Person addNewPerson(Person person); // Create
    Person updatePerson(Person person); // Update

    List<Person> getAllPersons(); //Retrive
    boolean deletePerson(Long id); //Delete

}
