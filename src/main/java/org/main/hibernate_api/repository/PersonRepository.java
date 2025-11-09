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
        // Получаем всех пользователей и фильтруем по городу
        List<Person> allPersons = entityManager
                .createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();

        return allPersons.stream()
                .filter(person -> city.equalsIgnoreCase(person.getCityOfLiving()))
                .toList();
    }

    // Альтернативная реализация с JPQL запросом (более эффективная)
    public List<Person> getPersonsByName(String name) {
        return entityManager
                .createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class)
                .setParameter("name", name)
                .getResultList();
    }
}