package by.myadel.Homework11;

import java.util.LinkedList;
import java.util.List;

public class Root {
    private String name;
    private List<People> people = new LinkedList<>();

    public void addPeople(People people) {
        this.people.add(people);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }
}
