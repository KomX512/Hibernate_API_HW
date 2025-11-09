package org.main.hibernate_api.repository;

import jakarta.persistence.EntityManager;
import org.main.hibernate_api.entity.Person;
import org.springframework.stereotype.Repository;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {

        return entityManager
                .createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class)
                .setParameter("city", city.toUpperCase())
                .getResultList();
    }

    public List<Person> getPersonsByName(String name) {
        return entityManager
                .createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Person> getAll() {
        return entityManager
                .createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

}