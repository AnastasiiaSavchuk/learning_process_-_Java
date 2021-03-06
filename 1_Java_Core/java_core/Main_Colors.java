package java_core;

import java.util.Locale;
import java.util.Scanner;

public class Main_Colors {

    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);;

    public static void main(String[] args) throws Exception {
        System.out.print("Start - enter any number : ");

        int stop = sc.nextInt();
        while (stop != 0) {
            System.out.print("Enter minute by hour : ");
            double t = sc.nextDouble();
            double colorTime = t % 5;

            if (colorTime >= 0 && colorTime < 3) {
                System.out.println("--- green ---");
            } else if (colorTime >= 3 && colorTime < 4) {
                System.out.println("--- yellow ---");
            } else {
                System.out.println("--- red ---");
            }

            System.out.print("Exit - 0, continue - any number : ");
            stop = sc.nextInt();
        }
    }
}