package org.main.hibernate_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PERSONS")
@Getter
@Setter
@IdClass(Person.PersonId.class)
public class Person {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Id
    @Column(name = "surname", nullable = false)
    private String surname;

    @Id
    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false)
    private String cityOfLiving;

    public Person() {
    }

    public Person(String name, String surname, Integer age, String phoneNumber, String cityOfLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving.toUpperCase();
    }

    // Статический класс для составного ключа
    @Getter
    @Setter
    public static class PersonId implements Serializable {
        private String name;
        private String surname;
        private Integer age;

        public PersonId() {
        }

        public PersonId(String name, String surname, Integer age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonId personId = (PersonId) o;
            return Objects.equals(name, personId.name) &&
                    Objects.equals(surname, personId.surname) &&
                    Objects.equals(age, personId.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname, age);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}