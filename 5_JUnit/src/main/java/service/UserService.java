package service;


import dao.Address;
import dao.Animal;
import dao.User;
import exception.NoSuchUserException;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<User, List<Animal>> showAll();

    boolean checkUserByAge(int id) throws NoSuchUserException;

    User getUserById(int id) throws NoSuchUserException;

    void addNewAddress(int id, Address address) throws NoSuchUserException;

    void removeAddress(int id) throws NoSuchUserException;

    void addAnimal(User user, Animal animal);

    void showAnimalForUser(User userToShow);

    Animal getAnimalByType(User user, String animal);

    void removeAnimal(User user, Animal animal);

    void changeFullName(int id, String name) throws NoSuchUserException;
}
