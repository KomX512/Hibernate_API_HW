package org.main.hibernate_api.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter

public class PersonId implements Serializable {
    private String name;
    private String surname;
    private Integer age;

    // Конструкторы
    public PersonId() {}

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