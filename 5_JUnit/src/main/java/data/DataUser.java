package data;

import dao.Address;
import dao.Animal;
import dao.User;

import java.util.*;

public class DataUser {

    private static Map<User, List<Animal>> map = new LinkedHashMap<>();

    public static Map<User, List<Animal>> data() {

        User user1 = new User(1, "Dima", new Address(1, "lviv", 394, "Shevchenka"), 30);
        List<Animal> animal1 = new ArrayList<>(Arrays.asList(new Animal(1, "Dog", "Di"),
                new Animal(1, "Cat", "Bonia")));
        User user2 = new User(2, "Ksenia", new Address(2, "lviv", 404, "Shevchenka"), 26);
        List<Animal> animal2 = new ArrayList<>(Arrays.asList(new Animal(2, "Dog", "Rudi"),
                new Animal(2, "Parrot", "Kesha")));
        User user3 = new User(3, "Olia", new Address(3, "Kropyvnytskiy", 21, "Osipenko"), 17);
        List<Animal> animal3 = new ArrayList<>(Arrays.asList(new Animal(3, "Rabbit", "Elli"),
                new Animal(3, "Turtle", "Sem")));
        User user4 = new User(4, "Vania", new Address(4, "Lutsk", 48, "Korolenka"), 20);
        List<Animal> animal4 = new ArrayList<>(Arrays.asList(new Animal(4, "Fish", "Gold"),
                new Animal(4, "Cat", "Monk")));
        User user5 = new User(5, "Kolia", new Address(5, "Kyiv", 7, "Abdurahmanova"), 42);
        List<Animal> animal5 = new ArrayList<>(Arrays.asList(new Animal(5, "Fox", "Cheese"),
                new Animal(5, "Worm", "Hen")));

        map.put(user1, animal1);
        map.put(user2, animal2);
        map.put(user3, animal3);
        map.put(user4, animal4);
        map.put(user5, animal5);

        return map;
    }
}