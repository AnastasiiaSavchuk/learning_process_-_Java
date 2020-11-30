package stream.stream_list_io;

import stream.stream_list_io.service.impl.DeviseServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static DeviseServiceImpl deviseService = new DeviseServiceImpl();

    public static void main(String[] args) throws IOException {
        int stop = 0;

        do {
            System.out.println("Choose option : \n" +
                    "1 - See all devise.\n" +
                    "2 - Show devise sorted by serial number. \n" +
                    "3 - Show device sorted by brand. \n" +
                    "4 - Show devise cost more 400 \n" +
                    "5 - Show devise sorted by serial number contain 0 and cost less 800 \n" +
                    "6 - Show max cost devise\n" +
                    "7 - Exit!");

            int serves = sc.nextInt();
            switch (serves) {
                case 1:
                    deviseService.showAll();
                    break;
                case 2:
                    deviseService.showDeviseBySerialNumber();
                    break;
                case 3:
                    deviseService.sortedByBrand();
                    break;
                case 4:
                    deviseService.showDeviseCostMore();
                    break;
                case 5:
                    deviseService.showDeviseBySerialNumberAndCost();
                    break;
                case 6:
                    deviseService.maxCostDevise();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }
            System.out.println("Exit - 0, continue - any number!");
            stop = sc.nextInt();
        } while (stop != 0);
    }
}


