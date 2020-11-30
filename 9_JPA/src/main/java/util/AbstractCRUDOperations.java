package util;

import java.util.List;

public interface AbstractCRUDOperations<E> {

    List<E> readAll();

    E readById(int id);

    void create(E e);

    void delete(int id);
}