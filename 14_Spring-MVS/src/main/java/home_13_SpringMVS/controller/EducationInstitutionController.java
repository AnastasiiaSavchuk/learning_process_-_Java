package home_13_SpringMVS.controller;

import home_13_SpringMVS.model.EducationInstitution;
import home_13_SpringMVS.service.impl.EducationInstitutionServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

import static javax.servlet.http.HttpServletResponse.*;

@Slf4j
@RestController
public class EducationInstitutionController {

    @Autowired
    private EducationInstitutionServiceImpl service;

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Validation error occurred. " +
                    "Some fields are empty or incorrect input")
    })
    @PostMapping("/educationInstitutions")
    public ResponseEntity<?> eddNewEducationInstitution(@RequestBody EducationInstitution educationInstitution, UriComponentsBuilder builder) {
        if (service.isExist(educationInstitution.getId())) {
            log.error("Education Institution {}, with id {} already exists", educationInstitution, educationInstitution.getId());
            return new ResponseEntity<>((HttpStatus.CONFLICT));
        }
        service.save(educationInstitution);
        log.info("Education Institution {} was added", educationInstitution);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/educationInstitutions/{id}").buildAndExpand(educationInstitution.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_NO_CONTENT, message = "No Education Institutions in database"),
    })
    @ApiOperation(value = "Search for Education Institution by id",
            response = EducationInstitution.class,
            responseContainer = "List")
    @GetMapping("/educationInstitutions/{id}")
    public ResponseEntity<?> getEducationInstitutionById(@PathVariable("id") int id) {
        log.info("Looking for a education institution by id {}", id);
        EducationInstitution educationInstitution = service.findById(id);
        if (Objects.isNull(educationInstitution)) {
            log.error("No education institution with id {} found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(educationInstitution, HttpStatus.OK);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_NO_CONTENT, message = "No Education Institutions in database"),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Validation error occurred. " +
                    "Some fields are empty or incorrect input")
    })
    @ApiOperation(value = "Retrieves information about all Education Institutions",
            response = EducationInstitution.class,
            responseContainer = "List")
    @GetMapping("/educationInstitutions")
    public ResponseEntity<List<EducationInstitution>> getAllEducationInstitution() {
        log.info("Looking for all education institutions");
        List<EducationInstitution> educationInstitutions = service.findAll();
        if (educationInstitutions.isEmpty()) {
            log.info("No records found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(educationInstitutions, HttpStatus.OK);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Validation error occurred. " +
                    "Some fields are empty or incorrect input")
    })
    @PutMapping("/educationInstitutions/{id}")
    public ResponseEntity<?> updateEducationInstitutionById(@RequestBody EducationInstitution educationInstitution, @PathVariable("id") int id) {
        if (!service.isExist(id)) {
            log.error("Education Institution {}, with id {} doesn't exists", educationInstitution, educationInstitution.getId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EducationInstitution previous = service.findById(id);
        educationInstitution.setId(id);
        service.update(educationInstitution);
        log.info("Education Institution {} was updated into {}", previous, educationInstitution);
        return new ResponseEntity<>(educationInstitution, HttpStatus.OK);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_NO_CONTENT, message = "No Education Institutions in database"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
    })
    @DeleteMapping("educationInstitutions/{id}")
    public ResponseEntity<?> deleteEducationInstitutionById(@PathVariable("id") int id) {
        if (Objects.isNull(service.findById(id))) {
            log.error("Education Institution with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        log.info("Education Institution {} was deleted", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_NO_CONTENT, message = "No Education Institutions in database"),
    })
    @ApiOperation(value = "Search for Education Institution by accreditation",
            response = EducationInstitution.class,
            responseContainer = "List")
    @GetMapping("/educationInstitutionsByAccreditation/{accreditation}")
    public ResponseEntity<?> getEducationInstitutionsByAccreditation(@PathVariable("accreditation") int accreditation) {
        log.info("Looking for education institutions by accreditation {}", accreditation);
        List<EducationInstitution> educationInstitutions = service.findByAccreditationOrderById(accreditation);
        if (educationInstitutions.isEmpty()) {
            log.error("No education institution with accreditation {} found", accreditation);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(educationInstitutions, HttpStatus.OK);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_NO_CONTENT, message = "No Education Institutions in database"),
    })
    @ApiOperation(value = "Search for Education Institution by countStudents more ? and countInstitutes ? ",
            response = EducationInstitution.class,
            responseContainer = "List")
    @GetMapping("/educationInstitutionsByCountStudentsAndCountInstitutes/{countStudents}/{countInstitutes}")
    public ResponseEntity<?> getEducationInstitutionsByCountStudentsAndCountInstitutes(@PathVariable("countStudents") int countStudents, @PathVariable("countInstitutes") int countInstitutes) {
        log.info("Looking for education institutions where countStudents more than {} and countInstitutes less than {}", countStudents, countInstitutes);
        List<EducationInstitution> educationInstitutions = service.findByCountStudentsGreaterThanAndCountInstitutesLessThan(countStudents, countInstitutes);
        if (educationInstitutions.isEmpty()) {
            log.error("No education institutions with countStudents more than {} OR countInstitutes less than {} found", countStudents, countInstitutes);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(educationInstitutions, HttpStatus.OK);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_NO_CONTENT, message = "No Education Institutions in database"),
    })
    @ApiOperation(value = "Search for Education Institution by address",
            response = EducationInstitution.class,
            responseContainer = "List")
    @GetMapping("/educationInstitutionsByAddress/{address}")
    public ResponseEntity<?> getEducationInstitutionByAddress(@PathVariable("address") String address) {
        log.info("Looking for education institutions by address {}", address);
        List<EducationInstitution> educationInstitutions = service.findByAddress(address);
        if (educationInstitutions.isEmpty()) {
            log.error("No education institutions with address {} found", address);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(educationInstitutions, HttpStatus.OK);
    }

    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "Ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_NO_CONTENT, message = "No Education Institutions in database"),
    })
    @ApiOperation(value = "Search for Education Institution by moreStudent more ? and lessStudent ? ",
            response = EducationInstitution.class,
            responseContainer = "List")
    @GetMapping("/educationInstitutionsByCountStudentsAndCountStudents/{moreStudent}/{lessStudent}")
    public ResponseEntity<?> getEducationInstitutionByCountStudentsAndCountStudents(@PathVariable("moreStudent") int moreStudent, @PathVariable("lessStudent") int lessStudent) {
        log.info("Looking for education institutions where countStudents more than {} and countStudents less than {}", moreStudent, lessStudent);
        List<EducationInstitution> educationInstitutions = service.findByCountStudentsGreaterThanAndCountStudentsLessThan(moreStudent, lessStudent);
        if (educationInstitutions.isEmpty()) {
            log.error("No education education institutions where countStudents more than {} OR countStudents less than {} found", moreStudent, lessStudent);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(educationInstitutions, HttpStatus.OK);
    }
}