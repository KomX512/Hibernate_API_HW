package org.main.hibernate_api.controller;

import lombok.AllArgsConstructor;
import org.main.hibernate_api.entity.Person;
import org.main.hibernate_api.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city.toUpperCase());
    }

    // Дополнительный endpoint с оптимизированной версией
    @GetMapping("/by-name")
    public List<Person> getPersonsByName(@RequestParam String name) {
        return personRepository.findByName(name);
    }

    @GetMapping("/by-name-surname")
    public ResponseEntity<Person> getPersonByNameAndSurname(
            @RequestParam String name,
            @RequestParam String surname) {
        Optional<Person> person = personRepository.findByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam Integer age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    //---------CRUD
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            // Приводим city к верхнему регистру
            person.setCityOfLiving(person.getCityOfLiving().toUpperCase());
            Person savedPerson = personRepository.save(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        try {
            // Проверяем существование записи
            Person.PersonId personId = new Person.PersonId(
                    person.getName(),
                    person.getSurname(),
                    person.getAge()
            );

            if (personRepository.existsById(personId)) {
                person.setCityOfLiving(person.getCityOfLiving().toUpperCase());
                Person updatedPerson = personRepository.save(person);
                return ResponseEntity.ok(updatedPerson);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Удалить персону
    @DeleteMapping("/{name}/{surname}/{age}")
    public ResponseEntity<Void> deletePerson(
            @PathVariable String name,
            @PathVariable String surname,
            @PathVariable Integer age) {
        Person.PersonId personId = new Person.PersonId(name, surname, age);
        if (personRepository.existsById(personId)) {
            personRepository.deleteById(personId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
