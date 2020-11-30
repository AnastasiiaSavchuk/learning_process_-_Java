package home_14.service;

import home_14.model_domain.request.StudentRegistrationMultipart;
import org.springframework.web.multipart.MultipartFile;

public interface StudentRegistrationMultipartService {

    StudentRegistrationMultipart saveStudent(String firstName, String lastName, int age, MultipartFile file);

    StudentRegistrationMultipart getStudent(String studentId);
}