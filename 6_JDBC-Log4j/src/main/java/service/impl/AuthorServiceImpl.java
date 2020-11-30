package service.impl;

import dao.Author;
import dao.Book;
import dao.SQLConstants;
import exception.AuthorAlreadyCreateException;
import exception.NoSuchAuthorException;
import exception.NoSuchBookException;
import jdbc.MySqlConnector;
import org.apache.log4j.Logger;
import service.AuthorService;
import service.BookService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private static final Logger logger = Logger.getLogger(AuthorServiceImpl.class);
    private static BookService bookService = new BookServiceImpl();
    private static Connection connection = MySqlConnector.getConnection();

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLConstants.GET_ALL_AUTHORS)) {
            while (resultSet.next()) {
                Book book = bookService.getBookById(resultSet.getInt("book_id"));
                Author author = new Author(resultSet.getInt("author_id"),
                        resultSet.getString("author_name"), resultSet.getString("author_surname"),
                        resultSet.getString("author_email"), resultSet.getString("day_of_birth"),
                        book);
                authors.add(author);
                logger.info("Get all cities request was processed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author getAuthorById(int id) throws SQLException {
        ResultSet resultSet = null;
        Author author = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_AUTHOR_BY_ID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Book book = bookService.getBookById(resultSet.getInt("book_id"));
                author = new Author(resultSet.getInt("author_id"),
                        resultSet.getString("author_name"), resultSet.getString("author_surname"),
                        resultSet.getString("author_email"), resultSet.getString("day_of_birth"),
                        book);
                logger.info("Getting author with id : " + id);
            } else {
                logger.error("No author with id : " + id);
                throw new NoSuchAuthorException("No author with id : " + id);
            }
        } catch (SQLException | NoSuchAuthorException e) {
            e.printStackTrace();
        } finally {
            resultSet.close();
        }
        return author;
    }

    @Override
    public void createAuthor(Author author) throws AuthorAlreadyCreateException, NoSuchBookException {
        if (bookService.isExists(author.getBook().getId())) {
            if (isExists(author.getAuthorId())) {
                throw new AuthorAlreadyCreateException("Author is already create!");
            } else {
                try (PreparedStatement statement = connection.prepareStatement(SQLConstants.CREATE_AUTHOR)) {
                    statement.setInt(1, author.getAuthorId());
                    statement.setString(2, author.getAuthorName());
                    statement.setString(3, author.getAuthorSurname());
                    statement.setString(4, author.getAuthorEmail());
                    statement.setString(5, author.getDayOfBirth());
                    statement.setInt(6, author.getBook().getId());
                    statement.execute();
                    logger.info("Creating author with id : " + author.getAuthorId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            logger.error("Author is NOT exists! Author : " + author.getAuthorId());
            throw new NoSuchBookException("Book is NOT exists!");
        }
    }

    @Override
    public void updateAuthor(int previous, Author current) throws NoSuchBookException, NoSuchAuthorException {
        if (isExists(previous)) {
            if (bookService.isExists(current.getBook().getId())) {
                try (PreparedStatement statement = connection.prepareStatement(SQLConstants.UPDATE_AUTHOR)) {
                    statement.setInt(1, current.getAuthorId());
                    statement.setString(2, current.getAuthorName());
                    statement.setString(3, current.getAuthorSurname());
                    statement.setString(4, current.getAuthorEmail());
                    statement.setString(5, current.getDayOfBirth());
                    statement.setInt(6, current.getBook().getId());
                    statement.setInt(7, previous);
                    statement.execute();
                    logger.info("Updating author with id : " + previous);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                logger.error("Book is NOT exists! Book : " + current.getBook().getId());
                throw new NoSuchBookException("Book is NOT exists!");
            }
        } else {
            logger.error("No author to update with id " + previous);
            throw new NoSuchAuthorException("No author to update with id " + previous);
        }
    }

    @Override
    public void deleteAuthorById(int id) throws NoSuchAuthorException {
        if (isExists(id)) {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_AUTHOR_BY_ID)) {
                statement.setInt(1, id);
                statement.execute();
                logger.info("Deleting author with id : " + id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            logger.error("No author to delete with id : " + id);
            throw new NoSuchAuthorException("No author to delete with id " + id);
        }
    }

    private List<Author> getAll() {
        return getAllAuthors();
    }

    @Override
    public boolean isExists(int authorId) {
        boolean flag = false;
        for (Author author : getAllAuthors()) {
            flag = author.getAuthorId() == authorId;
            if (flag) {
                break;
            }
        }
        return flag;
    }
}
