package java_colection.zoo_map.service;

import java_colection.zoo_map.dto.Animal;
import java_colection.zoo_map.dto.Person;
import java_colection.zoo_map.exception.NoEntityException;

public interface ZooClubService {

    void addPerson(Person person);

    void addAnimalToPerson(Person person, Animal animal);

    Person getPersonByName(String name) throws NoEntityException;

    void deleteAnimalFromPerson(Person person, Animal animal);

    void showAnimalForPerson(Person person);

    Animal getAnimalByType(Person person, String animal);

    void deletePersonFromClub(Person person);

    void showAll();
}
