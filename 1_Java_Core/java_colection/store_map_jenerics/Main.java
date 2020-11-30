package java_colection.store_map_jenerics;

import java_colection.store_map_jenerics.dto.Apple;
import java_colection.store_map_jenerics.dto.Price;
import java_colection.store_map_jenerics.service.NoEntityException;
import java_colection.store_map_jenerics.service.impl.AppleServiceImpl;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static AppleServiceImpl appleService = new AppleServiceImpl();

    public static void main(String[] args) throws NoEntityException {

        int stop = 0;
        do {
            System.out.println("Choose option : \n" +
                    "1 - Add new Apple.\n" +
                    "2 - Remove Apple price from type.\n" +
                    "3 - Remove Apple type from map.\n" +
                    "4 - Show only Apple type.\n" +
                    "5 - Show only Apple prise.\n" +
                    "6 - Show all.\n" +
                    "7 - Exit!");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Apple<String> apple = new Apple<>();
                    System.out.println("Enter Apple type : ");
                    apple.setType(scanner.next());
                    appleService.addApple(apple);

                    System.out.println("Enter Apple type for add new Apple price from existing :");
                    appleService.showAll();
                    Apple appleToAddPrice = appleService.getAppleByType(scanner.next());
                    Price priceToAdd = new Price();
                    System.out.println("Enter Apple  model:");
                    priceToAdd.setModel(scanner.next());
                    System.out.println("Enter Apple cost :");
                    priceToAdd.setCost(scanner.nextInt());
                    appleService.addPrice(appleToAddPrice, priceToAdd);
                    break;
                case 2:
                    System.out.println("Enter apple type for remove apple prise from existing :");
                    appleService.showAll();
                    Apple appleToRemovePrice = appleService.getAppleByType(scanner.next());
                    System.out.println("Enter Apple model from existing to delete :");
                    appleService.showPriceForAppleType(appleToRemovePrice);
                    Price priceToRemove = appleService.getPriceByModel(appleToRemovePrice, scanner.next());
                    appleService.removeAppleByPrice(appleToRemovePrice, priceToRemove);
                    break;
                case 3:
                    System.out.println("Enter Apple type to remove from existing :");
                    appleService.showAll();
                    Apple appleToRemove = appleService.getAppleByType(scanner.next());
                    appleService.removeAppleByType(appleToRemove);
                    break;
                case 4:
                    appleService.showKey();
                    break;
                case 5:
                    appleService.showValue();
                    break;
                case 6:
                    appleService.showAll();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }
            System.out.println("Stop - 0, continue - eny number.");
            stop = scanner.nextInt();
        } while (stop != 0);
    }
}
