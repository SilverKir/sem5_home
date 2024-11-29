package com.example.sem5home1.controller;

import com.example.sem5home1.model.Person;
import com.example.sem5home1.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {
   private final PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long personId) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.getPersonById(personId));
    }

    @PostMapping
    public ResponseEntity<Person> setNewPerson(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addNewPerson(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long personId,
                                               @RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.updatePerson(personId, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable("id") Long personId) {
        service.deletePersonById(personId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("deleted");
    }
}
