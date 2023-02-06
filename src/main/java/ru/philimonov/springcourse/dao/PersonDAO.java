package ru.philimonov.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.philimonov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 32, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jack", 28, "jack@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Robby", 14, "Romb@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sarah", 56, "sh@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Frederica", 54, "fred@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p->p.getId()==id);
    }
}
