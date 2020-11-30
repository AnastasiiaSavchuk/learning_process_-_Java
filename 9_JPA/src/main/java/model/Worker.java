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
@Table(name = "worker")
public class Worker {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "title")
    private String title;
    @Column(name = "salary")
    private int salary;
}