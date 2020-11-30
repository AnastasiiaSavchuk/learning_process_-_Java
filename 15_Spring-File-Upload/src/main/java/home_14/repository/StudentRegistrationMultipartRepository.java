package home_14.repository;

import home_14.model_domain.request.StudentRegistrationMultipart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegistrationMultipartRepository extends JpaRepository<StudentRegistrationMultipart, String> {
}