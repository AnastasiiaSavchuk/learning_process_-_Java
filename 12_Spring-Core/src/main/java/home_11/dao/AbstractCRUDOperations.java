package home_11.dao;

import java.util.List;

public interface AbstractCRUDOperations<E> {

    List<E> readAll();

    E readById(int id);

    void create(E e);

    void update(E e, String property, String newValue);

    void delete(int id);
}