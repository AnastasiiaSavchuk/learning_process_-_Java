package service;

import model.Item;

import java.util.List;

public interface ItemService {

    Item readById(int id);

    List<Item> readAll();

    void create(Item item);

    void update(int previousId, Item updated);

    void delete(int id);
}
