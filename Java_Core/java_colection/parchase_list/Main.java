package java_colection.parchase_list;

import java_colection.parchase_list.data.impl.PurchaseRepositoryImpl;
import java_colection.parchase_list.dto.Purchase;
import java_colection.parchase_list.service.impl.PurchaseServiceImpl;

import java.util.Collection;
import java.util.Scanner;

public class Main {

    static PurchaseRepositoryImpl purchaseRepository = new PurchaseRepositoryImpl();
    static PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int stop = 0;
        do {
            purchaseRepository.add(inputPurchase());
            System.out.println("Continue - 1 , exit - 0.");
            stop = scanner.nextInt();
        } while (stop != 0);

        System.out.println("Sorted by input :");
        showAllList(purchaseService.getAllByInput());

        System.out.println("\nSorted by hash :");
        showAllList(purchaseService.getAllByHash());

        System.out.println("\nSorted by count :");
        showAllList(purchaseService.getAllByCount());

        System.out.println("\nSorted by name :");
        showAllList(purchaseService.getAllByName());
    }

    private static void showAllList(Collection<Purchase> purchases) {
        for (Purchase purchase : purchases) {
            System.out.println(purchase + " " + purchase.hashCode());
        }
    }

    private static Purchase inputPurchase() {
        System.out.println("Insert name of purchase :");
        String name = scanner.next();
        System.out.println("Insert count of purchase :");
        int count = scanner.nextInt();
        return new Purchase(name, count);
    }
}
