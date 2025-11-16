package org.main.hibernate_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.main.hibernate_api.entity.Person;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Person.PersonId> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("SELECT p FROM Person p WHERE p.id.age < :age ORDER BY p.id.age ASC")
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") Integer age);

    @Query("SELECT p FROM Person p WHERE p.id.name = :name AND p.id.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("SELECT p FROM Person p WHERE p.id.name = :name")
    List<Person> findByName(@Param("name") String name);

    @Query("SELECT p FROM Person p")
    List<Person> findAll();

}
