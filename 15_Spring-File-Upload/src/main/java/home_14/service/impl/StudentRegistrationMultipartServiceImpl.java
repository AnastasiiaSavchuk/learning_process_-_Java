package home_14.service.impl;

import home_14.model_domain.request.StudentRegistrationMultipart;
import home_14.repository.StudentRegistrationMultipartRepository;
import home_14.service.StudentRegistrationMultipartService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentRegistrationMultipartServiceImpl implements StudentRegistrationMultipartService {

    @Autowired
    private StudentRegistrationMultipartRepository repository;

    @SneakyThrows
    @Override
    public StudentRegistrationMultipart saveStudent(String firstName, String lastName, int age, MultipartFile image) {
        return repository.save(new StudentRegistrationMultipart(firstName, lastName,
                age, image.getBytes()));
    }

    @Override
    public StudentRegistrationMultipart getStudent(String studentId) {
        return repository.findById(studentId).orElseThrow(NullPointerException::new);
    }
}
