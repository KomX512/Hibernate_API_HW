package org.main.hibernate_api.controller;

import lombok.AllArgsConstructor;
import org.main.hibernate_api.entity.Person;
import org.main.hibernate_api.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.getPersonsByCity(city);
    }

    // Дополнительный endpoint с оптимизированной версией
    @GetMapping("/by-name")
    public List<Person> getPersonsByName(@RequestParam String name) {
        return personRepository.getPersonsByName(name);
    }

    @GetMapping("/all")
    public List<Person> getPersonsByCity() {
        return personRepository.getAll();
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person savedPerson = personRepository.save(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        try {
            Person updatedPerson = personRepository.save(person);
            return ResponseEntity.ok(updatedPerson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
