package org.main.hibernate_api.repository;

import jakarta.persistence.EntityManager;
import org.main.hibernate_api.entity.Person;
import org.springframework.stereotype.Repository;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Person save(Person person) {

        if (person.getName() == null || person.getSurname() == null || person.getAge() == null) {
            System.out.println("Нет полей для создания...");
            throw new IllegalArgumentException("Требуемые поля: name, surname and age!");

        }

        // Проверяем, существует ли уже запись с таким составным ключом
        List<Person> chek = entityManager
                .createQuery("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname AND p.age = :age", Person.class)
                .setParameter("name", person.getName())
                .setParameter("surname", person.getSurname())
                .setParameter("age", person.getAge())
                .getResultList();

        if (chek.size() != 0) {
            // Если запись существует, обновляем ее
           // System.out.println("Есть такая запись");
            Person existing = chek.get(0);
            existing.setPhoneNumber(person.getPhoneNumber());
            existing.setCityOfLiving(person.getCityOfLiving());
            return entityManager.merge(existing);
        } else {
            // Если записи нет, сохраняем новую
            //System.out.println("Добавляем в базу");
            person.setCityOfLiving(person.getCityOfLiving().toUpperCase());
            //System.out.println(person);
            entityManager.persist(person);
            return person;
        }
    }
}