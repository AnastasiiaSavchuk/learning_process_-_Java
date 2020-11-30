package stream.stream_people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Nastia", 27, "female"),
                new Person("Dima", 30, "male"),
                new Person("Rostuk", 19, "male"),
                new Person("Ania", 18, "female"),
                new Person("Sergiy", 58, "male"),
                new Person("Emma", 54, "female")));

        System.out.println("1. Men who are conscripts : ");
        people.stream().filter(men -> men.getAge() >= 18 && men.getAge() <= 27 && men.getSex().equals("male")).forEach(System.out::println);

        System.out.println("\n2. Average age of men : ");
        double average = people.stream().filter(men -> men.getSex().equals("male")).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(average);

        System.out.println("\n3. Working people : ");
        people.stream().filter(women -> women.getSex().equals("female") && women.getAge() >= 18 && women.getAge() < 55).forEach(System.out::println);
        people.stream().filter(men -> men.getSex().equals("male") && men.getAge() >= 18 && men.getAge() < 60).forEach(System.out::println);

        System.out.println("\n4. Sorted in reverse alphabetical order : ");
        people.stream().sorted(new ReversComparator()).forEach(System.out::println);

        System.out.println("\n5. Sorted by name : ");
        people.stream().sorted(new SortedByName()).forEach(System.out::println);
        System.out.println("\nSorted by age : ");
        people.stream().sorted(new SortedByAge()).forEach(System.out::println);

        System.out.println("\n6. The oldest person : ");
        Person max = people.stream().max(new SortedByAge()).orElseThrow();
        System.out.println(max);

        System.out.println("\n7. The youngest person : ");
        Person min = people.stream().min(new SortedByAge()).orElseThrow();
        System.out.println(min);

        System.out.println("\n8. Count mеn : ");
        long countMan = people.stream().filter(men -> men.getSex().equals("male")).count();
        System.out.println(countMan);

        System.out.println("\n9. Count women : ");
        long countWomen = people.stream().filter(women -> women.getSex().equals("female")).count();
        System.out.println(countWomen);

        System.out.println("\n10. Show all women who name started with 'A' : ");
        people.stream().filter(women -> women.getName().startsWith("A")).forEach(System.out::println);
    }
}
