package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private int authorId;
    private String authorName;
    private String authorSurname;
    private String authorEmail;
    private String dayOfBirth;
    private Book book;
}
