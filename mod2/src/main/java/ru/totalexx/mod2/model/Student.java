package ru.totalexx.mod2.model;


import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Student {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final int age;

    public Student(String firstName, String lastName, int age) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
