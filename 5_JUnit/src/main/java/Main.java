import dao.Animal;
import dao.User;
import data.DataUser;
import exception.NoSuchUserException;
import service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static UserServiceImpl userService = new UserServiceImpl();
    private static Map<User, List<Animal>> map = DataUser.data();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchUserException {

        userService.showAll();

        //System.out.println(userService.checkUserByAge(3));

        //userService.addNewAddress(1, new Address(2, "lutsk", 25, "lkjlhvf"));

        //userService.removeAddress(3);

        //userService.addAnimal(new User(5, "Kolia", new Address(5, "Kyiv", 7,"Abdurahmanova"), 42), new Animal(1, "soyka", "sdfgdg"));

        //userService.removeAnimal(new User(5, "Kolia", new Address(5, "Kyiv", 7,"Abdurahmanova"), 42), new Animal(1, "soyka", "sdfgdg"));

        //userService.changeFullName(4, "Sasha);

    }
}