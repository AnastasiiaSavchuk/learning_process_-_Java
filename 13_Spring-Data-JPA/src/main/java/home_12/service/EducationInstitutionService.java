package home_12.service;

import home_12.model.EducationInstitution;

import java.util.List;

public interface EducationInstitutionService {

    EducationInstitution save(EducationInstitution educationInstitution);

    EducationInstitution findById(int id);

    List<EducationInstitution> findAll();

    EducationInstitution update(EducationInstitution educationInstitution);

    void deleteById(int id);

    List<EducationInstitution> findByAccreditationOrderById(int accreditation);

    List<EducationInstitution> findByCountStudentsGreaterThanAndCountInstitutesLessThan(int countStudents, int countInstitutes);

    List<EducationInstitution> findByAddress(String address);

    List<EducationInstitution> findByCountStudentsGreaterThanAndCountStudentsLessThan(int moreStudent, int lessStudent);
}