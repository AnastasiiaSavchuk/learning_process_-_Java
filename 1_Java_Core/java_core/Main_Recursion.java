package java_core;

import java.util.Scanner;

public class Main_Recursion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number : ");
        int yourNumber = sc.nextInt();
        System.out.println("Your numbers from 1 to " + yourNumber + " :");
        System.out.println(recursionFunction(yourNumber));
    }

    public static String recursionFunction(int num) {
        if (num == 1) {
            return "1";
        }
        return recursionFunction(num - 1) + "\n" + num;
    }
}