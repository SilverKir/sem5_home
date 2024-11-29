package com.example.sem5home1.service;

import com.example.sem5home1.model.Person;
import com.example.sem5home1.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Person addNewPerson(Person person) {
        return repository.save(person);
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public Person getPersonById(Long personId) {
        Optional<Person> selectedPerson = repository.findById(personId);
        if (selectedPerson.isPresent()) {
            return selectedPerson.get();
        } else {
            throw new IllegalArgumentException("The is no person with id:" + personId);
        }
    }

    public Person updatePerson(Long personId, Person person) {
        person.setId(personId);
        return repository.save(person);
    }

    public void deletePersonById(Long personId) {
        repository.deleteById(personId);
    }
}
