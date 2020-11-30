import dao.Address;
import dao.Animal;
import dao.User;
import data.DataUser;
import exception.NoSuchUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.*;

public class UserServiceTest {

    private static UserService userService;

    @BeforeAll
    static void init() {
        userService = new UserServiceImpl();
    }

    @Test
    @DisplayName("Read all users")
    public void showAll() {
        Map<User, List<Animal>> userMap = userService.showAll();
        Assertions.assertTrue(userMap.size() > 0);
    }

    @Test
    @DisplayName("Check user by age")
    public void checkUserByAgeTest() throws NoSuchUserException {
        Assertions.assertTrue(userService.checkUserByAge(1));
        Assertions.assertFalse(userService.checkUserByAge(3));
        Assertions.assertThrows(NoSuchUserException.class, () -> userService.checkUserByAge(15555));
    }

    @Test
    @DisplayName("Add new address")
    public void addNewAddressTest() throws NoSuchUserException {
        int userId = 1;
        Address expectedAdd = new Address(1, "Test-city", 0, "test-street");
        userService.addNewAddress(userId, expectedAdd);
        User userAdd = userService.getUserById(userId);
        Address actualAdd = userAdd.getAddress();
        Assertions.assertEquals(expectedAdd, actualAdd);

        Address expectedRemove = null;
        userService.removeAddress(userId);
        User userRemove = userService.getUserById(userId);
        Address actualRemove = userRemove.getAddress();
        Assertions.assertEquals(expectedRemove, actualRemove);
    }

    @Test
    @DisplayName("Add and remove animal")
    public void addAndRemoveAnimalTest() {
        Map<User, List<Animal>> mapExpected = DataUser.data();
        User user = new User(1, "Dima", new Address(1, "lviv", 394, "Shevchenka"), 30);
        Animal animalAdd = new Animal(1, "test", "test");
        userService.addAnimal(user, animalAdd);

        Map<User, List<Animal>> mapAdd = new LinkedHashMap<>();
        User userAdd = new User(1, "Dima", new Address(1, "lviv", 394, "Shevchenka"), 30);
        List<Animal> animal = new ArrayList<>(Arrays.asList(new Animal(1, "Dog", "Di"),
                new Animal(1, "Cat", "Bonia"), new Animal(1, "test", "test")));
        mapAdd.put(userAdd, animal);
        Assertions.assertEquals(mapExpected.get(user), mapAdd.get(userAdd));

        userService.removeAnimal(user, animalAdd);
        Map<User, List<Animal>> mapRemove = new LinkedHashMap<>();
        User userRemove = new User(1, "Dima", new Address(1, "lviv", 394, "Shevchenka"), 30);
        List<Animal> animalRemove = new ArrayList<>(Arrays.asList(new Animal(1, "Dog", "Di"),
                new Animal(1, "Cat", "Bonia")));
        mapRemove.put(userRemove, animalRemove);

        Assertions.assertEquals(mapExpected.get(user), mapRemove.get(userRemove));
    }

    @Test
    @DisplayName("Change full name")
    public void changeFullName() throws NoSuchUserException {
        int userId = 1;
        String name = "Sasha";
        User userActual = new User(1, "Dima", new Address(1, "lviv", 394, "Shevchenka"), 30);
        userService.changeFullName(userId, name);
        User userExpected = new User(1, "Dima", new Address(1, "lviv", 394, "Shevchenka"), 30);
        Assertions.assertEquals(userExpected, userActual);
    }
}