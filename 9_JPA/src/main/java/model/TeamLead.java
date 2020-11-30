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
@Table(name = "team_lead")
public class TeamLead {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "salary")
    private int salary;
}