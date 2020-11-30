package service;

import model.Cart;

import java.util.List;

public interface CartService {

    Cart readById(int id);

    List<Cart> readAll();

    void create(Cart cart);

    void update(int previousId, Cart updated);

    void delete(int id);
}
