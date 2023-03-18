package com.backbase.learnspringboot.service;

import com.backbase.learnspringboot.entity.Person;
import com.backbase.learnspringboot.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Person updatePerson(Long id, Person person) throws Exception {

        Optional<Person> optPerson= repository.findById(id);
        if(optPerson.isPresent()){
            Person newPerson = repository.save(person);
            return newPerson;
        }else{
            throw new Exception("No records with that id" + person.getId());
        }
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
