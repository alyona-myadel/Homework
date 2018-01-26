package by.myadel.Homework19;

import com.fasterxml.jackson.databind.MappingIterator;

import java.util.*;

public class MyCollection<Department, Staff> implements MyCollectionContract<Department, Staff> {
    private Map<Department, List<Staff>> staff = new HashMap<>();
    private Staff director;

    @Override
    public void setDirector(Staff director) {
        this.director = director;
    }

    @Override
    public Staff getDirector() {
        return director;
    }

    @Override
    public void removeDirector() {
        if (director == null) {
            return;
        }
        director = null;
    }

    @Override
    public void addDepartment(Department department) {
        staff.put(department, new ArrayList<Staff>());
    }

    @Override
    public void removeDepartment(Department department) {
        staff.remove(department);
    }

    @Override
    public void addStaff(Staff staff, Department department) {
        this.staff.get(department).add(staff);
    }

    @Override
    public void removeStaff(Staff staff, Department department) {
        this.staff.get(department).remove(staff);
    }


    @Override
    public void moveStaff(Staff staff, Department departmentOut, Department departmentIn) {
        removeStaff(staff, departmentOut);
        addStaff(staff, departmentIn);
    }

    public Iterator<Staff> iterator() {
        return new MyCollectionIterator();
    }

    public class MyCollectionIterator implements Iterator<Staff> {
        private Iterator<Map.Entry<Department, List<Staff>>> entryIterator;
        private Iterator<Staff> staffIterator;
        private Map.Entry<Department, List<Staff>> entry;

        public MyCollectionIterator() {
            entryIterator = staff.entrySet().iterator();
        }

        @Override
        public boolean hasNext() {
            if (staffIterator != null && staffIterator.hasNext()) {
                return true;
            } else if (entryIterator.hasNext()) {
                entry = entryIterator.next();
                staffIterator = entry.getValue().iterator();
                return hasNext();
            }
            return false;
        }

        @Override
        public Staff next() {
            return staffIterator.next();
        }
    }

}
