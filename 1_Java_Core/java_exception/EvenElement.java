package java_exception;

import java_exception.exception.IncorrectElementException;

import java.util.Scanner;

public class EvenElement {

    public static void main(String[] args) throws IncorrectElementException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number : ");

        int number = exception(sc);
        checkElement(number);
    }

    private static int exception(Scanner sc) throws IncorrectElementException {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            throw new IncorrectElementException("Your number is not whole!!!");
        }
    }

    private static void checkElement(int number) {
        if (number % 2 != 0) {
            System.out.println("Your number isn't even : " + number);
        } else {
            System.out.println("Your number even : " + number);
        }
    }
}
