package home_13_SpringMVS.repository;

import home_13_SpringMVS.model.EducationInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationInstitutionRepository extends JpaRepository<EducationInstitution, Integer>, CrudRepository<EducationInstitution, Integer> {

    List<EducationInstitution> findByAccreditationOrderById(int accreditation);

    List<EducationInstitution> findByCountStudentsGreaterThanAndCountInstitutesLessThan(int countStudents, int countInstitutes);

    List<EducationInstitution> findByAddress(String address);

    List<EducationInstitution> findByCountStudentsGreaterThanAndCountStudentsLessThan(int moreStudent, int lessStudent);
}