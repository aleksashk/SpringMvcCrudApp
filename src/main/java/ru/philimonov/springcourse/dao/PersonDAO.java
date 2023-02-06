package ru.philimonov.springcourse.dao;

import ru.philimonov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Jack"));
        people.add(new Person(++PEOPLE_COUNT, "Robby"));
        people.add(new Person(++PEOPLE_COUNT, "Sarah"));
        people.add(new Person(++PEOPLE_COUNT, "Frederica"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
