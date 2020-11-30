package service.impl;

import dao.Address;
import dao.Animal;
import dao.User;
import data.DataUser;
import exception.NoSuchUserException;
import service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

    private static Scanner scanner = new Scanner(System.in);
    private Map<User, List<Animal>> map = DataUser.data();

    @Override
    public Map<User, List<Animal>> showAll() {
        map.forEach((k, v) -> System.out.println(k + " " + v));
        return map;
    }

    @Override
    public User getUserById(int id) throws NoSuchUserException {
        final User[] checkUser = {null};
        map.forEach((user, animalList) -> {
            if (user.getId() == id) {
                checkUser[0] = user;
            }
        });
        if (checkUser[0] == null) {
            throw new NoSuchUserException("User with id : " + id + " not found");
        }
        return checkUser[0];
    }

    @Override
    public boolean checkUserByAge(int id) throws NoSuchUserException {
        User user = getUserById(id);
        if (Objects.isNull(user)) {
            throw new NoSuchUserException("User with id " + id + " not found!");
        } else {
            return user.getAge() >= 18;
        }
    }

    @Override
    public void addNewAddress(int id, Address address) throws NoSuchUserException {
        User user = getUserById(id);
        if (Objects.isNull(user)) {
            throw new NoSuchUserException("User with id " + id + " not found!");
        } else {
            user.setAddress(address);
        }
    }

    @Override
    public void removeAddress(int id) throws NoSuchUserException {
        User user = getUserById(id);
        if (Objects.isNull(user)) {
            throw new NoSuchUserException("User with id " + id + " not found!");
        } else {
            user.setAddress(null);
        }
    }

    @Override
    public void addAnimal(User user, Animal animal) {
        for (Map.Entry<User, List<Animal>> entry : map.entrySet()) {
            if (entry.getKey().equals(user)) {
                List<Animal> animalToAdd = entry.getValue();
                animalToAdd.add(animal);
                entry.setValue(animalToAdd);
            }
        }
    }

    @Override
    public void showAnimalForUser(User userToShow) {
        for (Animal animal : map.get(userToShow)) {
            System.out.println(animal);
        }
    }

    @Override
    public Animal getAnimalByType(User user, String animal) {
        final Animal[] animals = {null};
        map.get(user).forEach(animalList -> {
            if (animalList.getType().equalsIgnoreCase(animal)) {
                animals[0] = animalList;
            }
        });
        return animals[0];
    }

    @Override
    public void removeAnimal(User user, Animal animal) {
        List<Animal> animalList;
        for (Map.Entry<User, List<Animal>> entry : map.entrySet()) {
            if (entry.getKey().equals(user)) {
                animalList = entry.getValue();
                animalList.remove(animal);
                entry.setValue(animalList);
            }
        }
    }

    @Override
    public void changeFullName(int id, String name) throws NoSuchUserException {
        User user = getUserById(id);
        user.setFullName(name);
    }
}
