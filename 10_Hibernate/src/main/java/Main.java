import model.Cart;
import model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.CartService;
import service.ItemService;
import service.impl.CartServiceImpl;
import service.impl.ItemServiceImpl;
import util.SessionFactoryUtil;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    private static CartService cartService = new CartServiceImpl();
    private static ItemService itemService = new ItemServiceImpl();

    public static void main(String[] args) {

        Session session = SessionFactoryUtil.getSession();

        Transaction transaction = session.beginTransaction();

        Cart cart1 = new Cart("total-cart-1", "name-1");
        Item item1 = new Item("total-item-1");
        Item item2 = new Item("total-item-2");
        Item item3 = new Item("total-item-3");
        Item item4 = new Item("total-item-4");

        cart1.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));

        Cart cart2 = new Cart("total-cart-2", "name-2");
        Item item5 = new Item("total-item-5");
        Item item6 = new Item("total-item-6");
        Item item7 = new Item("total-item-7");
        Item item8 = new Item("total-item-8");

        cart2.setItems(new HashSet<>(Arrays.asList(item5, item6, item7, item8)));

        session.persist(cart1);
        session.persist(cart2);

        transaction.commit();
        session.close();
    }
}