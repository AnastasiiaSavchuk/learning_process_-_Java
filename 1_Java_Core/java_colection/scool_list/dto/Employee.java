package java_colection.scool_list.dto;

import java_colection.scool_list.dto.enums.DepartmentName;
import java_colection.scool_list.dto.enums.KindOfWorks;

public class Employee {

    private String name;
    private int age;
    private String email;
    private DepartmentName departmentName;
    private KindOfWorks kindOfWorks;
    private int hour;

    public Employee(String name, int age, String email, DepartmentName departmentName, KindOfWorks kindOfWorks, int hour) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.departmentName = departmentName;
        this.kindOfWorks = kindOfWorks;
        this.hour = hour;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    public KindOfWorks getKindOfWorks() {
        return kindOfWorks;
    }

    public void setKindOfWorks(KindOfWorks kindOfWorks) {
        this.kindOfWorks = kindOfWorks;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return name + ", department : " + departmentName + ", age : " + age + ", works : " + kindOfWorks + ", hour pre month : " + hour + ", email : "
                + email + ";";
    }
}
