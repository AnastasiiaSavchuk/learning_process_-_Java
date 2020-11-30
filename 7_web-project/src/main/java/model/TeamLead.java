package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLead {

    private int id;
    private String fullName;
    private Timestamp dateOfBirth;
    private int salary;
}