package io;

import java.io.*;
import java.util.List;

public class Methods {

    public static void serializeEmployee(Employee employee) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("E:/Java/home_serialize.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(employee);
            System.out.println("Employee was serialized !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeEmployee() {
        Object o = null;
        try (FileInputStream fileInputStream = new FileInputStream("E:/Java/home_serialize.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            o = objectInputStream.readObject();
            System.out.println("Employee was DE serialized !");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static void serializeList(List<Employee> employeeList) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("E:/Java/home_serialize.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(employeeList);
            System.out.println("Employee was serialized !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> deserializeList(List<Employee> employeeList) {
        try (FileInputStream fileInputStream = new FileInputStream("E:/Java/home_serialize.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            objectInputStream.readObject();
            System.out.println("Employee was DE serialized !");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
