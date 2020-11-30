package home_14.controller;

import home_14.model_domain.request.StudentRegistrationMultipart;
import home_14.model_domain.response.MultipartUploadResponse;
import home_14.service.impl.StudentRegistrationMultipartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentRegistrationMultipartController {

    @Autowired
    private StudentRegistrationMultipartServiceImpl service;

    @PostMapping("/uploadStudent")
    public MultipartUploadResponse uploadResponse(@RequestParam("firstName") String firstName,
                                                  @RequestParam("lastName") String lastName,
                                                  @RequestParam("age") String age,
                                                  @RequestParam("image") MultipartFile image) {
        StudentRegistrationMultipart studentRegistration = service.saveStudent(firstName, lastName, Integer.parseInt(age), image);
        String showStudentUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/showStudent/")
                .path(studentRegistration.getId()).toUriString();
        return new MultipartUploadResponse(firstName, lastName, Integer.parseInt(age), showStudentUri);
    }

    @GetMapping("/showStudent/{id}")
    public ResponseEntity<Resource> showStudent(@PathVariable("id") String studentId) {
        StudentRegistrationMultipart studentMultipart = service.getStudent(studentId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(studentMultipart.getLastName()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment ; student=\"" + studentMultipart.getLastName() + "\"")
                .body(new ByteArrayResource(studentMultipart.getImage()));
    }
}
