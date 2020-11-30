package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.IdRandomGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    private int id;
    private String fullName;
    private String title;
    private int salary;

    public Worker(String fullName, String title, int salary) {
        this.id = IdRandomGenerator.getRandomID();
        this.fullName = fullName;
        this.title = title;
        this.salary = salary;
    }
}