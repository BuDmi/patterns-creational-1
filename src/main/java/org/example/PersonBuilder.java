package org.example;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address = null;

    public PersonBuilder setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }

        this.name = name;

        return this;
    }
    public PersonBuilder setSurname(String surname) {
        if (surname.isEmpty()) {
            throw new IllegalArgumentException("Surname is empty");
        }

        this.surname = surname;

        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age value is less than 0");
        }

        this.age = OptionalInt.of(age);

        return this;
    }
    public PersonBuilder setAddress(String address) {
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Address value is empty");
        }

        this.address = address;

        return this;
    }

    public Person build() {
        if (this.name.isEmpty()) {
            throw new IllegalStateException("Name is empty");
        }
        if (this.surname.isEmpty()) {
            throw new IllegalStateException("Surname is empty");
        }
        Person person;
        if (this.age.isPresent()) {
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(address);

        return person;
    }
}