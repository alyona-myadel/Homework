package by.myadel.Homework19;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer, Integer> myCollection = new MyCollection<>();
        Integer department1 = 404;
        Integer department2 = 402;
        myCollection.addDepartment(department1);
        myCollection.addDepartment(department2);
        myCollection.addStaff(42, department1);
        myCollection.addStaff(32, department2);
        Iterator<Integer> integerIterator = myCollection.iterator();
        System.out.println("Get the ID of all employees: ");
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
    }
}
