package by.myadel.Homework7;

import java.util.LinkedList;
import java.util.List;

public class StudentsDataStore {
    private LinkedList<Student> students = new LinkedList<>();

    public void addStudent(Student concreteStudent) {
        students.add(concreteStudent);
    }

    public List<Student> getAllPatients() {
        return students;
    }
}