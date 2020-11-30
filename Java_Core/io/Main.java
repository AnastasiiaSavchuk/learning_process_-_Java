package io;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
// 1
        Employee employee1 = new Employee("Kolia", 1, 12549, 26);
        Methods.serializeEmployee(employee1);
        Employee employee2 = (Employee) Methods.deserializeEmployee();
        System.out.println(employee2);
//2
        Employee employee3 = new Employee("Marta", 2, 114395, 15);
        Methods.serializeEmployee(employee3);
        Employee employee4 = (Employee) Methods.deserializeEmployee();
        System.out.println(employee4);
//3
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Sasha", 3, 10254, 28));
        employeeList.add(new Employee("Lilia", 4, 10254, 20));
        employeeList.add(new Employee("Sasha", 5, 10254, 25));
        Methods.serializeList(employeeList);
        List<Employee> employeeList1 = Methods.deserializeList(employeeList);
        System.out.println(employeeList1);
    }
}
