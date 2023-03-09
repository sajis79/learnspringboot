package com.backbase.learnspringboot.service;

import com.backbase.learnspringboot.entity.Person;
import com.backbase.learnspringboot.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository repository;
    @Override
    public Person addNewPerson(Person person) {
        Person newPerson = repository.save(person);
        return newPerson;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> people = repository.findAll();
        return people;
    }

    @Override
    public boolean deletePerson(Long id) {
        repository.deleteById(id);
        return true;
    }
}
