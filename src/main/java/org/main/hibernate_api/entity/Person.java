package org.main.hibernate_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSONS")
@IdClass(PersonId.class)
@Getter
@Setter

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

    // Конструкторы
    public Person() {}

    public Person(String name, String surname, Integer age, String phoneNumber, String cityOfLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
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