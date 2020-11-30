package service.impl;

import model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.ItemService;
import util.SessionFactoryUtil;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private Session session;
    private Transaction transaction;

    public ItemServiceImpl() {
        session = SessionFactoryUtil.getSession();
        transaction = session.beginTransaction();
    }

    @Override
    public Item readById(int id) {
        return session.get(Item.class, id);
    }

    @Override
    public List<Item> readAll() {
        return session.createCriteria(Item.class).list();
    }

    @Override
    public void create(Item item) {
        session.persist(item);
        transaction.commit();
    }

    @Override
    public void update(int previousId, Item updated) {
        Item itemForUpdate = readById(previousId);
        itemForUpdate.setTotal(updated.getTotal());

        session.persist(itemForUpdate);
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        Item item = readById(id);

        session.delete(item);
        transaction.commit();
    }
}