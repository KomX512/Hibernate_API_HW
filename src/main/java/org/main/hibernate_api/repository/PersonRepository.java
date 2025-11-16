package org.main.hibernate_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.main.hibernate_api.entity.Person;

import java.util.List;
import java.util.Optional;


@Repository
public interface  PersonRepository extends JpaRepository<Person, Person.PersonId> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<Person> findByNameAndSurname(String name, String surname);

    List<Person> findByName(String name);

    List<Person> findAll();

}
