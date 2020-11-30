package java_exception;

import java_exception.exception.IncorrectElementException;

import java.util.Scanner;

public class AddElement {

    public static void main(String[] args) throws IncorrectElementException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number one : ");
            int a = sc.nextInt();
            System.out.println("Enter number two : ");
            int b = sc.nextInt();
            int sum = a + b;
            System.out.println("sum = " + sum);
        } catch (Exception exception) {
            throw new IncorrectElementException("You entered a not whole number!!!");
        }
    }
}