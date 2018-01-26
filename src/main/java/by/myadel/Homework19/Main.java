package by.myadel.Homework19;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyCollection<Staff, Department> myCollection = new MyCollection<>();
        Staff staff = new Staff();
        staff.setStaffId(11);
        staff.setStaffName("Ivanov");
        Department department = new Department();
        department.setId(404);
        department.setName("departament");
        myCollection.addStaff(department, staff);
        myCollection.addDepartment(staff);
        Iterator<Department> integerIterator = myCollection.iterator();
        if (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
        System.out.println(myCollection.getDirector());
        Iterator<Department> iterator = myCollection.iterator();
        do {
            iterator.next();
            iterator.remove();
        } while (iterator.hasNext());
    }
}
