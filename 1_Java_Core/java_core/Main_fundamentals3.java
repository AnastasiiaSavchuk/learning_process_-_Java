package java_core;

import java.util.Scanner;

public class Main_fundamentals3 {
    public static void main(String[] args) {

        firstHome();
        secondHome();
        thirdHome();
    }

    private static void firstHome() {
        System.out.println(" 1. Bank. ");
        Scanner scn = new Scanner(System.in);
        double m, n, k, K = 0;
        System.out.println("Enter your deposit : ");
        m = scn.nextDouble();
        System.out.println("Enter your rate : ");
        n = scn.nextDouble();
        System.out.println("Enter how many years your deposit in the bank : ");
        k = scn.nextDouble();

        for (int i = 0; i < k; i++) {
            K += (m / 100 * n);
        }
        System.out.println("Final deposit : " + K + " UAN");
    }

    private static void secondHome() {
        System.out.println(" 2. Mass.");
        int[] mass = new int[10];
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the elements of the array :");

        for (int i = 0; i < 10; i++) {
            mass[i] = scn.nextInt();
        }
        System.out.println("Your array :");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + mass[i]);
        }
        System.out.println("\nYour array in reverse order :");
        for (int i = mass.length - 1; i >= 0; i--) {
            System.out.print(" " + mass[i]);
        }
    }

    private static void thirdHome() {
        System.out.println(" 3. Multidimensional array.");

        int[][] array = new int[5][7];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 75) - 2;
            }
        }
        for (int i = 0; i < array.length; i++, System.out.println()) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
    }
}