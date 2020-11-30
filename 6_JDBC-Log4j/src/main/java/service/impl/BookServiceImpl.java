package service.impl;

import dao.Book;
import dao.SQLConstants;
import exception.BookAlreadyCreatedException;
import exception.NoSuchBookException;
import jdbc.MySqlConnector;
import org.apache.log4j.Logger;
import service.BookService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private static final Logger logger = Logger.getLogger(BookServiceImpl.class);
    private static Connection connection = MySqlConnector.getConnection();


    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLConstants.GET_ALL_BOOKS)) {
            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("id"), resultSet.getString("book_name"),
                        resultSet.getString("discription"), resultSet.getInt("price"),
                        resultSet.getInt("isbn"));
                books.add(book);
                logger.info("Get all books request was processed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getBookById(int id) throws SQLException {
        ResultSet resultSet = null;
        Book book = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_BOOK_BY_ID)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book = new Book(resultSet.getInt("id"), resultSet.getString("book_name"),
                        resultSet.getString("discription"), resultSet.getInt("price"),
                        resultSet.getInt("isbn"));
                logger.info("Getting book with id : " + id);
                logger.debug("debug");
                return book;
            } else {
                logger.error("No book with id :" + id);
                logger.warn("this is warning");
                throw new NoSuchBookException("No book with id :" + id);
            }
        } catch (SQLException | NoSuchBookException e) {
            e.printStackTrace();
        } finally {
            resultSet.close();
        }
        return book;
    }

    @Override
    public void createBook(Book book) throws BookAlreadyCreatedException {
        if (isExists(book.getId())) {
            throw new BookAlreadyCreatedException("Book with id : " + book.getId() + "already created");
        } else {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstants.CREATE_BOOK)) {
                statement.setInt(1, book.getId());
                statement.setString(2, book.getBookName());
                statement.setString(3, book.getDiscription());
                statement.setInt(4, book.getPrice());
                statement.setInt(5, book.getIsbn());
                statement.execute();
                logger.info("Creating new book : " + book);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateBook(int previous, Book current) throws NoSuchBookException {
        if (isExists(previous)) {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstants.UPDATE_BOOK)) {
                statement.setInt(1, current.getId());
                statement.setString(2, current.getBookName());
                statement.setString(3, current.getDiscription());
                statement.setInt(4, current.getPrice());
                statement.setInt(5, current.getIsbn());
                statement.setInt(6, previous);
                statement.execute();
                logger.info("Updating book with id : " + previous);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            logger.error("No such book to update with id : " + previous);
            throw new NoSuchBookException("No such book to update with id : " + previous);
        }
    }

    @Override
    public void deleteBookById(int id) throws NoSuchBookException {
        if (isExists(id)) {
            try (PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_BOOK_BY_ID)) {
                statement.setInt(1, id);
                statement.execute();
                logger.info("Deleting book with id : " + id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            logger.error("No such book to update with id : " + id);
            throw new NoSuchBookException("No such book to update with id : " + id);
        }
    }

    private List<Book> getAll() {
        return getAllBooks();
    }

    @Override
    public boolean isExists(int bookId) {
        boolean flag = false;
        for (Book book : getAll()) {
            flag = book.getId() == bookId;
            if (flag) {
                break;
            }
        }
        return flag;
    }
}
