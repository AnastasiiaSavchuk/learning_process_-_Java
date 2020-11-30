package home_11.app;

import home_11.dao.impl.StudentDaoImpl;
import home_11.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class,args);

		StudentDaoImpl service = (StudentDaoImpl) context.getBean("studentDao");
		Student student1 = (Student) context.getBean("student1");
		Student student2 = (Student) context.getBean("student2");
		Student student3 = (Student) context.getBean("student3");
		Student student4 = (Student) context.getBean("student4");
		Student student5 = (Student) context.getBean("student5");

		service.create(student1);
		service.create(student2);
		service.create(student3);
		service.create(student4);
		service.create(student5);

		System.out.println(service.readById(1));

		System.out.println("All student :");
		service.readAll().forEach(System.out::println);

		service.update(student1,"name", "Hrystyna");

		System.out.println("All student after update:");
		service.readAll().forEach(System.out::println);

		service.delete(5);

		System.out.println("All student after delete:");
		service.readAll().forEach(System.out::println);
    }
}