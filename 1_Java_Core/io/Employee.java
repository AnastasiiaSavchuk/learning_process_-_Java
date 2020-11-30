package io;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int id;
    private transient int salary;
    private Object days;

    public Employee(String name, int id, int salary, Object day) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.days = days;
    }

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Object getDay() {
        return days;
    }

    public void setDay(Object days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee name : " + name + ", id = " + id + ", salary = " + salary + ", days of work = " + days;
    }
}
