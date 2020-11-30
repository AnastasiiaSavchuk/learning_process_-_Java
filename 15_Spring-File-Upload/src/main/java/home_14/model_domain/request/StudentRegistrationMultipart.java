package home_14.model_domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class StudentRegistrationMultipart {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Lob
    @Column(name = "image")
    private byte[] image;

    public StudentRegistrationMultipart(String firstName, String lastName, int age, byte[] image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.image = image;
    }
}