package home_11.app;

import home_11.dao.StudentDao;
import home_11.dao.impl.StudentDaoImpl;
import home_11.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StudentConfiguration {

    @Bean(name = "studentDao")
    @Scope("singleton")
    public StudentDao getStudentDao() {
        return new StudentDaoImpl();
    }

    @Bean(name = "student1")
    public Student student1() {
        return new Student(1, "Anastasiia", 27);
    }

    @Bean(name = "student2")
    public Student student2() {
        return new Student(2, "Andiy", 34);
    }

    @Bean(name = "student3")
    public Student student3() {
        return new Student(3, "Lilia", 23);
    }

    @Bean(name = "student4")
    public Student student4() {
        return new Student(4, "Ivan", 25);
    }

    @Bean(name = "student5")
    public Student student5() {
        return new Student(5, "Sergiy", 33);
    }
}
