package home_15.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "person_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Person(String personName, String email, String password) {
        this.personName = personName;
        this.email = email;
        this.password = password;
    }
}