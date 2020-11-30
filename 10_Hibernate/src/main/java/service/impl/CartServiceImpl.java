package service.impl;

import model.Cart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.CartService;
import util.SessionFactoryUtil;

import java.util.List;

public class CartServiceImpl implements CartService {

    private Session session;
    private Transaction transaction;

    public CartServiceImpl() {
        session = SessionFactoryUtil.getSession();
        transaction = session.beginTransaction();
    }

    @Override
    public Cart readById(int id) {
        return session.get(Cart.class, id);
    }

    @Override
    public List<Cart> readAll() {
        return session.createCriteria(Cart.class).list();
    }

    @Override
    public void create(Cart cart) {
        session.persist(cart);
        transaction.commit();
    }

    @Override
    public void update(int previousId, Cart updated) {
        Cart cartForUpdate = readById(previousId);
        cartForUpdate.setTotal(updated.getTotal());
        cartForUpdate.setName(updated.getName());

        session.persist(cartForUpdate);
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        Cart cart = readById(id);

        session.delete(cart);
        transaction.commit();
    }
}