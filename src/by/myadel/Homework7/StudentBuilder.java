package by.myadel.Homework7;

import java.text.ParseException;

public class StudentBuilder {
    Student student = new Student();

    public StudentBuilder setName(String name) {
        student.setName(name);
        return this;
    }

    public StudentBuilder setSurname(String surname) {
        student.setSurname(surname);
        return this;
    }

    public StudentBuilder setDateOfBirth(String dateOfBirth) throws ParseException {
        student.setDateOfBirth(dateOfBirth);
        return this;
    }

    public Student build() {
        return student;
    }
}
