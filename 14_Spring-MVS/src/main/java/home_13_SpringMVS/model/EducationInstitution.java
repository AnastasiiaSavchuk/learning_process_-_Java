package home_13_SpringMVS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "education_institution")
@AllArgsConstructor
@NoArgsConstructor
public class EducationInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "institution_id")
    private int id;

    @Column(name = "institution_name")
    private String name;

    @Column(name = "institution_accreditation")
    private int accreditation;

    @Column(name = "count_institutes")
    private int countInstitutes;

    @Column(name = "count_students")
    private int countStudents;

    @Column(name = "institution_address")
    private String address;
}