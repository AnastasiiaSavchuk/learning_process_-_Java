package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "role")
    private String role;
    @Column(name = "name")
    private String name;
    @Column(name = "budget")
    private int budget;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}