package java_colection.scool_list.service.impl;

import java_colection.scool_list.data.DataBase;
import java_colection.scool_list.dto.Employee;
import java_colection.scool_list.dto.enums.DepartmentName;
import java_colection.scool_list.dto.enums.KindOfWorks;
import java_colection.scool_list.service.HourComparator;
import java_colection.scool_list.service.StatisticServes;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatisticServesImpl implements StatisticServes {

    Scanner scanner = new Scanner(System.in);

    public void checkEmployeeByEmail() {
        System.out.println("\"Enter name's worker :\"");
        String name = scanner.next();
        for (Employee employee : DataBase.employees) {
            if (name.equalsIgnoreCase(employee.getName())) {
                System.out.println(employee.getEmail());
            }
        }
    }

    public void addNewEmployee() {
        Employee addNewEmployee = new Employee();
        System.out.println("Enter employee name : ");
        addNewEmployee.setName(scanner.next());
        System.out.println("Enter employee age");
        addNewEmployee.setAge(scanner.nextInt());
        System.out.println("Enter employee email");
        addNewEmployee.setEmail(scanner.next());

        System.out.println("Choice your department :");
        for (DepartmentName value : DepartmentName.values()) {
            System.out.println(value);
        }
        System.out.println("Enter employee department name :");
        addNewEmployee.setDepartmentName(DepartmentName.valueOf(scanner.next().toUpperCase()));
        System.out.println("Choice employee kind Of work :");
        for (KindOfWorks value : KindOfWorks.values()) {
            System.out.println(value);
        }
        System.out.println("Enter employee kind of works :");
        addNewEmployee.setKindOfWorks(KindOfWorks.valueOf(scanner.next().toUpperCase()));
        System.out.println("Enter employee hour");
        addNewEmployee.setHour(scanner.nextInt());

        DataBase.employees.add(addNewEmployee);
    }

    @Override
    public void emailValidator() {
        String emailRegex = ".+\\.(com|ua|net)";
        Pattern pattern = Pattern.compile(emailRegex);

        for (Employee employee : DataBase.employees) {
            Matcher matcher = pattern.matcher(employee.getEmail());
            System.out.println(employee.getName() + ", your Email " + employee.getEmail() + " is : " + matcher.matches());
        }
    }

    public int getCountEmployeesOfLessons(KindOfWorks kindOfWorks) {
        int size = 0;
        for (Employee employee : DataBase.employees) {
            if (employee.getKindOfWorks().equals(kindOfWorks)) {
                size++;
            }
        }
        return size;
    }

    public void getCountMaxHour() {
        int maxHour = 0;
        HourComparator hourComparator = new HourComparator();
        DataBase.employees.sort(hourComparator);

        for (int i = 0; i < DataBase.employees.size(); i++) {
            maxHour = DataBase.employees.size() - 1;
        }
        System.out.println(DataBase.employees.get(maxHour));
    }

    @Override
    public List<Employee> getAllEmployee() {
        for (Employee employee : DataBase.employees) {
            System.out.println(employee);
        }
        return null;
    }
}
