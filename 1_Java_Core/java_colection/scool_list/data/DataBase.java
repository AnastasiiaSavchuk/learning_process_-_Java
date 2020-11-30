package java_colection.scool_list.data;

import java_colection.scool_list.dto.Employee;
import java_colection.scool_list.dto.enums.DepartmentName;
import java_colection.scool_list.dto.enums.KindOfWorks;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static List<Employee> employees = allEmployees();

    public static List<Employee> allEmployees() {

        List<Employee> employees = new ArrayList<>();
        Employee director = new Employee("Katia", 36, "sova.K@gmail.com", DepartmentName.DIRECTOR, KindOfWorks.LITERATURE, 205);
        Employee TeacherOne = new Employee("Olga", 28, "petrina.O@aska.com", DepartmentName.TEACHER, KindOfWorks.MATHS, 214);
        Employee TeacherTwo = new Employee("Ivan", 38, "ogonko.Iv@shara.ua", DepartmentName.TEACHER, KindOfWorks.PHYSICS, 278);
        Employee TeacherThree = new Employee("Dima", 58, "vazovski.m@mail.ru", DepartmentName.TEACHER, KindOfWorks.ASTRONOMY, 144);
        Employee TeacherFour = new Employee("Sasha", 31, "saymon@yndex.com", DepartmentName.TEACHER, KindOfWorks.ENGLISH, 224);
        Employee TeacherFive = new Employee("Gosha", 48, "gosha@mail.ru", DepartmentName.TEACHER, KindOfWorks.LITERATURE, 131);
        Employee TeacherSix = new Employee("Petro", 28, "petrO@aska.com", DepartmentName.TEACHER, KindOfWorks.MATHS, 168);
        Employee TeacherSeven = new Employee("Semen", 38, "sem@shara.ua", DepartmentName.TEACHER, KindOfWorks.ASTRONOMY, 192);
        Employee TeacherEight = new Employee("Sveta", 50, "sveta.m@mail.ru", DepartmentName.TEACHER, KindOfWorks.ENGLISH, 195);
        Employee TeacherNine = new Employee("Lilia", 41, "lol@yndex.com", DepartmentName.TEACHER, KindOfWorks.ENGLISH, 85);
        Employee TeacherTen = new Employee("Haluna", 48, "hell@mail.ru", DepartmentName.TEACHER, KindOfWorks.MATHS, 136);
        Employee TeacherEleven = new Employee("Ira", 39, "ogonko.ira@shara.ua", DepartmentName.TEACHER, KindOfWorks.MATHS, 154);
        Employee TeacherTwelve = new Employee("Roma", 36, "rIc@shara.ua", DepartmentName.TEACHER, KindOfWorks.PHYSICS, 58);

        Employee headTeacher = new Employee("Victoria", 44, "sabina.V@gmail.ua", DepartmentName.HEADTEACHER, KindOfWorks.MATHS, 168);
        Employee cleaning1 = new Employee("Petro", 39, "minaR@mail.com", DepartmentName.WORKER, KindOfWorks.HANDYMAN, 168);
        Employee cleaning2 = new Employee("Stepan", 39, "stepanH@gmail.com", DepartmentName.WORKER, KindOfWorks.HANDYMAN, 209);
        Employee cook1 = new Employee("Maria", 39, "meriSor@yndex.com", DepartmentName.WORKER, KindOfWorks.HANDYMAN, 202);
        Employee cook2 = new Employee("Kostia", 39, "rom@mail.com", DepartmentName.WORKER, KindOfWorks.HANDYMAN, 148);
        Employee cook3 = new Employee("Rita", 39, "ritAv@shara.ua", DepartmentName.WORKER, KindOfWorks.HANDYMAN, 154);

        employees.add(director);
        employees.add(TeacherOne);
        employees.add(TeacherTwo);
        employees.add(TeacherThree);
        employees.add(TeacherFour);
        employees.add(TeacherFive);
        employees.add(TeacherSix);
        employees.add(TeacherSeven);
        employees.add(TeacherEight);
        employees.add(TeacherNine);
        employees.add(TeacherTen);
        employees.add(TeacherEleven);
        employees.add(TeacherTwelve);
        employees.add(headTeacher);
        employees.add(cleaning1);
        employees.add(cleaning2);
        employees.add(cook1);
        employees.add(cook2);
        employees.add(cook3);

        return employees;
    }
}

