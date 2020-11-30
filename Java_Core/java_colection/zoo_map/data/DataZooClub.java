package java_colection.zoo_map.data;


import java_colection.zoo_map.dto.Animal;
import java_colection.zoo_map.dto.Person;

import java.util.*;

public class DataZooClub {

    public Map<Person, List<Animal>> map = new HashMap<>();

    public Map<Person, List<Animal>> fillWithData() {

        Person person1 = new Person("Dima", 30);
        List<Animal> animal1 = new ArrayList<>(Arrays.asList(new Animal("Cat", "Bonia"),
                new Animal("Dog", "Di"), new Animal("Parrot", "Kesha")));
        Person person2 = new Person("Olia", 19);
        List<Animal> animal2 = new ArrayList<>(Arrays.asList(new Animal("Rabbit", "Elli"),
                new Animal("Turtle", "Sem"), new Animal("Fish", "Gold")));
        Person person3 = new Person("Nastia", 27);
        List<Animal> animal3 = new ArrayList<>(Arrays.asList(new Animal("Fox", "Cheese"),
                new Animal("Raccoon", "Thief"), new Animal("Worm", "Hen")));
        map.put(person1, animal1);
        map.put(person2, animal2);
        map.put(person3, animal3);

        return map;
    }
}
