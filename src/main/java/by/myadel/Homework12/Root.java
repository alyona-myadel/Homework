package by.myadel.Homework12;

import java.util.Date;
import java.util.List;

public class Root {
    private String name;
    private int gender;
    private List<People> people;
    private Date date;

    public Root() {
    }

    public Root(String name, List<People> people, Date date) {
        this.name = name;
        this.people = people;
        this.date = date;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", people=" + people +
                ", date=" + date +
                '}';
    }
}
