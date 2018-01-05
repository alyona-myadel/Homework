package by.myadel.Homework10.Task2;

import java.util.ArrayList;
import java.util.List;

public class PeopleDataStore {
    private List<Person> people = new ArrayList<>();

    public List<Person> getPeopleDateStore() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void printRandomPerson() {
        int countPeople = people.size();
        int randomNumber = (int) (Math.random() * countPeople);
        System.out.println("Результат: " + people.get(randomNumber).toString());
    }
}
