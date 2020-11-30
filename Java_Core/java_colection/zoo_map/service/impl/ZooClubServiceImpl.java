package java_colection.zoo_map.service.impl;

import java_colection.zoo_map.data.DataZooClub;
import java_colection.zoo_map.dto.Animal;
import java_colection.zoo_map.dto.Person;
import java_colection.zoo_map.exception.NoEntityException;
import java_colection.zoo_map.service.ZooClubService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZooClubServiceImpl implements ZooClubService {

    private static DataZooClub data = new DataZooClub();
    private static Map<Person, List<Animal>> map = data.fillWithData();

    @Override
    public void addPerson(Person person) {
        map.put(person, new ArrayList<>());
    }

    @Override
    public void addAnimalToPerson(Person person, Animal animal) {
        for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
            if (entry.getKey().equals(person)) {
                List<Animal> animalToAdd = entry.getValue();
                animalToAdd.add(animal);
                entry.setValue(animalToAdd);
            }
        }
    }

    @Override
    public Person getPersonByName(String name) throws NoEntityException {
        Person person = null;
        for (Person p : map.keySet()) {
            if (name.equalsIgnoreCase(p.getName())) {
                person = p;
            }
        }
        if (person == null) {
            throw new NoEntityException("Person with name " + name + " not found");
        }
        return person;
    }

    @Override
    public void deleteAnimalFromPerson(Person person, Animal animal) {
        List<Animal> animalList;
        for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
            if (entry.getKey().equals(person)) {
                animalList = entry.getValue();
                animalList.remove(animal);
                entry.setValue(animalList);
            }
        }
    }

    @Override
    public void showAnimalForPerson(Person person) {
        for (Animal animal : map.get(person)) {
            System.out.println(animal);
        }
    }

    @Override
    public Animal getAnimalByType(Person person, String animal) {
        Animal animals = null;
        for (Animal animalToDelete : map.get(person)) {
            if (animalToDelete.getType().equalsIgnoreCase(animal)) {
                animals = animalToDelete;
            }
        }
        return animals;
    }

    @Override
    public void deletePersonFromClub(Person person) {
        map.remove(person);

    }

    @Override
    public void showAll() {
        for (Map.Entry<Person, List<Animal>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", have : " + entry.getValue());
        }
    }
}
