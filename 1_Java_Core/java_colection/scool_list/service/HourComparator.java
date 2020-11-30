package java_colection.scool_list.service;

import java_colection.scool_list.dto.Employee;

import java.util.Comparator;

public class HourComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getHour() - o2.getHour();
    }
}
