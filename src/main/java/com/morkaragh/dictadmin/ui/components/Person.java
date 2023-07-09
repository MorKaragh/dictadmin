package com.morkaragh.dictadmin.ui.components;

public class Person {
    private final String name;
    private final int yearOfBirth;

    public Person(String nicolaus_copernicus, int i) {
        this.name = nicolaus_copernicus;
        this.yearOfBirth = i;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
