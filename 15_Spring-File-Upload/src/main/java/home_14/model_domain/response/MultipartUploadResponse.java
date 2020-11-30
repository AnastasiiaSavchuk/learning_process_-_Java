package home_14.model_domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipartUploadResponse {

    private String FirstName;
    private String LastName;
    private int age;
    private String showStudentUri;
}