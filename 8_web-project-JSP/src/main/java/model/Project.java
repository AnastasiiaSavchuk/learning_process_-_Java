package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.IdRandomGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    private int id;
    private String role;
    private String name;
    private int budget;
    private String email;
    private String password;

    public Project(String role, String name, int budget, String email, String password) {
        this.id = IdRandomGenerator.getRandomID();
        this.role = role;
        this.name = name;
        this.budget = budget;
        this.email = email;
        this.password = password;
    }
}

