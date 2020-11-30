package java_colection.scool_list.service;

import java_colection.scool_list.dto.Employee;
import java_colection.scool_list.dto.enums.KindOfWorks;

import java.util.List;

public interface StatisticServes {

    void checkEmployeeByEmail();

    void addNewEmployee();

    void emailValidator();

    int getCountEmployeesOfLessons(KindOfWorks kindOfWorks);

    void getCountMaxHour();

    List<Employee> getAllEmployee();
}
