package home_13_SpringMVS.service.impl;

import home_13_SpringMVS.model.EducationInstitution;
import home_13_SpringMVS.repository.EducationInstitutionRepository;
import home_13_SpringMVS.service.EducationInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationInstitutionServiceImpl implements EducationInstitutionService {


    @Autowired
    private EducationInstitutionRepository repository;

    @Override
    public EducationInstitution save(EducationInstitution educationInstitution) {
        return repository.save(educationInstitution);
    }

    @Override
    public EducationInstitution findById(int id) {
        /*return repository.getOne(id);*/
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EducationInstitution> findAll() {
        return repository.findAll();
    }

    @Override
    public EducationInstitution update(EducationInstitution educationInstitution) {
        return repository.save(educationInstitution);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<EducationInstitution> findByAccreditationOrderById(int accreditation) {
        return repository.findByAccreditationOrderById(accreditation);
    }

    @Override
    public List<EducationInstitution> findByCountStudentsGreaterThanAndCountInstitutesLessThan(int countStudents, int countInstitutes) {
        return repository.findByCountStudentsGreaterThanAndCountInstitutesLessThan(countStudents, countInstitutes);
    }

    @Override
    public List<EducationInstitution> findByAddress(String address) {
        return repository.findByAddress(address);
    }

    @Override
    public List<EducationInstitution> findByCountStudentsGreaterThanAndCountStudentsLessThan(int moreStudent, int lessStudent) {
        return repository.findByCountStudentsGreaterThanAndCountStudentsLessThan(moreStudent, lessStudent);
    }

    @Override
    public boolean isExist(int id) {
        return repository.existsById(id);
    }
}