package java_colection.commodity_list;

import java_colection.commodity_list.data.impl.CommodityDataImpl;
import java_colection.commodity_list.servise.Impl.CommodityServiceImpl;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CommodityServiceImpl commodityService = new CommodityServiceImpl();
    private static CommodityDataImpl commodityData = new CommodityDataImpl();

    public static void main(String[] args) {
        int stop = 0;
        do {
            System.out.println("Choose option : \n" +
                    "1 - Add new commodity.\n" +
                    "2 - Remove old commodity.\n" +
                    "3 - Replacement some commodity.\n" +
                    "4 - Sorted by weight commodity.\n" +
                    "5 - Sorted by length commodity.\n" +
                    "6 - Sorted by width commodity. \n" +
                    "7 - Sorted by name commodity.\n" +
                    "8 - Get some element from collection.\n" +
                    "9 - Exit!");

            int service = scanner.nextInt();
            switch (service) {
                case 1:
                    commodityService.addCommodity();
                    System.out.println("New commodity list : \n");
                    commodityService.showList(commodityData.getAll());
                    break;
                case 2:
                    commodityService.removeCommodity();
                    System.out.println("Remove wardrobe and show new commodity list : \n ");
                    commodityService.showList(commodityData.getAll());
                    break;
                case 3:
                    commodityService.replacementCommodity();
                    System.out.println("Table replaced with Mirror\n");
                    commodityService.showList(commodityData.getAll());
                    break;
                case 4:
                    commodityService.getAllByLength();
                    System.out.println("Show all elements by Length : \n");
                    commodityService.showList(commodityData.getAll());
                    break;
                case 5:
                    commodityService.getAllByWidth();
                    System.out.println("Show all elements by Width : \n");
                    commodityService.showList(commodityData.getAll());
                    break;
                case 6:
                    commodityService.getAllByWeight();
                    System.out.println("Show all elements by Weight : \n");
                    commodityService.showList(commodityData.getAll());
                    break;
                case 7:
                    commodityService.getAllByName();
                    System.out.println("Show all elements by Name : \n");
                    commodityService.showList(commodityData.getAll());
                    break;
                case 8:
                    commodityService.getElementFromCollection();
                case 9:
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
