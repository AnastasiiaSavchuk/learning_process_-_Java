package java_colection.zoo_map;

import java_colection.zoo_map.dto.Animal;
import java_colection.zoo_map.dto.Person;
import java_colection.zoo_map.exception.NoEntityException;
import java_colection.zoo_map.service.impl.ZooClubServiceImpl;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ZooClubServiceImpl zooClubService = new ZooClubServiceImpl();

    public static void main(String[] args) throws NoEntityException {

        int stop;
        do {
            System.out.println("Choose option : \n" +
                    "1 - Add new person to zoo club.\n" +
                    "2 - Add new animal to person.\n" +
                    "3 - Remove animal from person.\n" +
                    "4 - Remove person from zoo club.\n" +
                    "5 - Show all.\n" +
                    "6 - Exit!");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Person person = new Person();
                    System.out.println("Enter person name : ");
                    person.setName(scanner.next());
                    System.out.println("Enter person age : ");
                    person.setAge(scanner.nextInt());
                    zooClubService.addPerson(person);
                    break;
                case 2:
                    System.out.println("Enter person name for add new animal from existing :");
                    zooClubService.showAll();
                    Person personToAddAnimal = zooClubService.getPersonByName(scanner.next());
                    Animal animalToAdd = new Animal();
                    System.out.println("Enter type animal :");
                    animalToAdd.setType(scanner.next());
                    System.out.println("Enter name animal :");
                    animalToAdd.setName(scanner.next());
                    zooClubService.addAnimalToPerson(personToAddAnimal, animalToAdd);
                    break;
                case 3:
                    System.out.println("Enter person name for delete animal from existing :");
                    zooClubService.showAll();
                    Person personToDeleteAnimal = zooClubService.getPersonByName(scanner.next());
                    System.out.println("Enter type animal from existing to delete :");
                    zooClubService.showAnimalForPerson(personToDeleteAnimal);
                    Animal animalToDelete = zooClubService.getAnimalByType(personToDeleteAnimal, scanner.next());
                    zooClubService.deleteAnimalFromPerson(personToDeleteAnimal, animalToDelete);
                    break;
                case 4:
                    System.out.println("Enter person name for delete from existing :");
                    zooClubService.showAll();
                    Person personToDelete = zooClubService.getPersonByName(scanner.next());
                    zooClubService.deletePersonFromClub(personToDelete);
                    break;
                case 5:
                    zooClubService.showAll();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }
            System.out.println("Exit - 0, continue - any number!");
            stop = scanner.nextInt();
        } while (stop != 0);
    }
}
