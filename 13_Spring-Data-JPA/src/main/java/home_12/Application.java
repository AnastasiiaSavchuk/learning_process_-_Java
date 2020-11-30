package home_12;

import home_12.model.EducationInstitution;
import home_12.service.EducationInstitutionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        EducationInstitutionService service = context.getBean(EducationInstitutionService.class);

        EducationInstitution educationInstitution1 = new EducationInstitution(1, "Київський політехнічний інститут", 4, 11, 21500, "Kyiv");
        EducationInstitution educationInstitution2 = new EducationInstitution(2, "Київський національний університет імені Тараса Шевченка", 4, 8, 28000, "Kyiv");
        EducationInstitution educationInstitution3 = new EducationInstitution(3, "Національний університет «Одеська юридична академія»", 4, 6, 16000, "Odesa");
        EducationInstitution educationInstitution4 = new EducationInstitution(4, "Одеський національний медичний університет", 4, 4, 9000, "Odesa");
        EducationInstitution educationInstitution5 = new EducationInstitution(5, "Національний лісотехнічний університет України", 3, 3, 7000, "Lviv");
        EducationInstitution educationInstitution6 = new EducationInstitution(6, "Техніко-економічний коледж", 2, 1, 1318, "Lviv");
        EducationInstitution educationInstitution7 = new EducationInstitution(7, "Харківський коледж текстилю та дизайну", 2, 1, 1658, "Harkiv");
        EducationInstitution educationInstitution8 = new EducationInstitution(8, "ХАРКІВСЬКИЙ ДЕРЖАВНИЙ АВТОТРАНСПОРТНИЙ КОЛЕДЖ", 2, 1, 1896, "Harkiv");

        /*service.save(educationInstitution1);
        service.save(educationInstitution2);
        service.save(educationInstitution3);
        service.save(educationInstitution4);
        service.save(educationInstitution5);
        service.save(educationInstitution6);
        service.save(educationInstitution7);
        service.save(educationInstitution8);*/

        /*System.out.println("read all");
        service.findAll().forEach(System.out::println);

        System.out.println("\nread by id");
        System.out.println(service.findById(1));

        System.out.println("\nread by accreditation");
        System.out.println(service.findByAccreditationOrderById(4));

        System.out.println("\nread by countStudents more than 400 and countInstitutes less than 4");
        System.out.println(service.findByCountStudentsGreaterThanAndCountInstitutesLessThan(400,4));

        System.out.println("\nread by address");
        System.out.println(service.findByAddress("lviv"));

        System.out.println("\nread by countStudents more than 1400 and countInstitutes less 20000 4\n");
        System.out.println(service.findByCountStudentsGreaterThanAndCountStudentsLessThan(1400,20000));*/

        /*System.out.println("update by id\n");
        service.save(educationInstitution8);
        EducationInstitution educationInstitution = service.findById(8);
        educationInstitution.setName("lalala");
        educationInstitution.setAccreditation(1);
        educationInstitution.setCountInstitutes(2);
        educationInstitution.setCountStudents(600);
        educationInstitution.setAddress("lviv");
        service.update(educationInstitution);*/

        /*System.out.println("delete by id\n");
        service.deleteById(8);*/
    }
}