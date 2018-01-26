package by.myadel.Homework19;

public interface MyCollectionContract<Department, Staff> extends Iterable<Staff> {
    // 3 methods to do head of firm
    void setDirector(Staff director);

    Staff getDirector();

    void removeDirector();

    // 3 methods to do departments
    void addDepartment(Department department);

    void removeDepartment(Department department);

    // few methods to do staff
    void addStaff(Staff staff, Department department);

    void removeStaff(Staff staff, Department department);

    void moveStaff(Staff staff, Department departmentOut, Department departmentIn);
}
