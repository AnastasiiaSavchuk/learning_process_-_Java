package home_11.dao.impl;

import home_11.dao.StudentDao;
import home_11.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentDaoImpl implements StudentDao {

    private List<Student> studentTable;

    public StudentDaoImpl() {
        studentTable = new ArrayList<>();
    }

    @Override
    public List<Student> readAll() {
        return studentTable;
    }

    @Override
    public Student readById(int id) {
        return studentTable.stream().filter(student -> student.getId() == id).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void create(Student student) {
        if (!studentTable.contains(student)) studentTable.add(student);
        else System.out.println("Student is already added.");
    }

    @Override
    public void update(Student student, String property, String newValue) {
        if (studentTable.contains(student) && Objects.nonNull(property)) {
            Student updated = student;
            int index = studentTable.indexOf(student);
            switch (property) {
                case "name": {
                    updated.setName(newValue);
                    break;
                }
                case "age": {
                    updated.setAge(Integer.parseInt(newValue));
                    break;
                }
                default: {
                    System.out.println("no such property.");
                    break;
                }
            }
            studentTable.set(index, updated);
        } else {
            System.out.println("There is no student OR property is null.");
        }
    }

    @Override
    public void delete(int id) {
        Student studentDelete = readById(id);
        if (Objects.nonNull(studentDelete)) studentTable.remove(studentDelete);
        else System.out.println("No student with id : " + id);
    }
}