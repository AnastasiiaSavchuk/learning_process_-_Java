package util.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerModel {
    private int id;
    private String fullName;
    private String title;
    private int salary;
    private int count;

}
