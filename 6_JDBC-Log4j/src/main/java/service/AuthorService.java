package service;

import dao.Author;
import exception.AuthorAlreadyCreateException;
import exception.NoSuchAuthorException;
import exception.NoSuchBookException;

import java.sql.SQLException;
import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(int id) throws SQLException;

    void createAuthor(Author author) throws AuthorAlreadyCreateException, NoSuchAuthorException, NoSuchBookException;

    void updateAuthor(int previous, Author current) throws NoSuchBookException, NoSuchAuthorException;

    void deleteAuthorById(int id) throws NoSuchAuthorException;

    boolean isExists(int authorId);
}
