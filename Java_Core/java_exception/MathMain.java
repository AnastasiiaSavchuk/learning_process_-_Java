package java_exception;

import java_exception.exception.MoreThenNullException;

import java.util.Scanner;

public class MathMain {

    public static void main(String[] args) throws MoreThenNullException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a = ");
        double a = sc.nextDouble();
        System.out.println("Enter b = ");
        double b = sc.nextDouble();

        validateElement(a, b);
    }

    private static void validateElement(double a, double b) throws MoreThenNullException {
        if (a < 0 && b < 0) {
            throw new IllegalArgumentException("a < 0 and b < 0");
        } else if ((a == 0 && b != 0) || (a != 0 && b == 0)) {
            throw new ArithmeticException("a = 0 and b != 0 or a != 0 and b = 0");
        } else if (a == 0 && b == 0) {
            throw new IllegalArgumentException("a = 0 and b = 0");
        } else if (a > 0 && b > 0) {
            throw new MoreThenNullException("a > 0 and b > 0");
        }
    }
}
