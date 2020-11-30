package service;

import dao.Book;
import exception.BookAlreadyCreatedException;
import exception.NoSuchBookException;

import java.sql.SQLException;
import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(int id) throws SQLException;

    void createBook(Book book) throws BookAlreadyCreatedException;

    void updateBook(int previous, Book current) throws NoSuchBookException;

    void deleteBookById(int id) throws NoSuchBookException;

    boolean isExists(int bookId);
}
