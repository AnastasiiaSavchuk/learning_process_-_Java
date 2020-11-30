package shared;

import exception.AlreadyExistException;
import exception.NotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCRUDOperations<E> {

    List<E> readAll() throws SQLException;

    E readById(int id) throws SQLException, NotFoundException;

    void create(E e) throws SQLException, AlreadyExistException;

    void update(int id, E current) throws SQLException, AlreadyExistException, NotFoundException;

    void delete(int id) throws SQLException, NotFoundException;
}