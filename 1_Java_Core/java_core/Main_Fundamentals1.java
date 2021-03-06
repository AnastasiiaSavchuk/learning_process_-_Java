package java_core;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Main_Fundamentals1 {

    public static void main(String[] args) {

        squareEquation();
        weekDays();
        first55Elements();
        less5Elements();
        evenOdd();
        closestToTen();
        maxMinElements();
    }

    private static void squareEquation() {
        System.out.println(" 1.");
        System.out.println(" Програма розв'язує рівняння:\n a*x^2 + b*x + c = 0");

        Scanner sc = new Scanner(System.in);
        double a, b, c, D, x, x1, x2;
        System.out.println("Ввудіть a :");
        a = sc.nextDouble();
        System.out.println("Ввудіть b :");
        b = sc.nextDouble();
        System.out.println("Ввудіть c :");
        c = sc.nextDouble();

        D = b * b - 4 * a * c;
        if (D == 0) {
            x = (-b) / (2 * a);
            System.out.println("Рівняння має один корінь : " + x);
        } else if (D > 0) {
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Рівняння має два розв'язки :" + " x1 = " + x1 + " x2 = " + x2);
        } else if (D < 0) {
            System.out.println("Рівняння не має розв'язків.");
        }
    }

    private static void weekDays() {
        System.out.println(" 2.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть день тижня : ");
        String day = sc.next();

        switch (day) {
            case "понеділок":
                System.out.println("1. Стрижка на 12.\n2. Англійська на 15\n3. Java на 17.30");
                break;
            case "вівторок":
                System.out.println("1. Зал на 13\n2. Скупитись продуктами\n3. Приготувати вечерю");
                break;
            case "середа":
                System.out.println("1. Англійська на 15\n2. Java на 17ю30");
                break;
            case "четвер":
                System.out.println("1. Зал на 13\n2. Зустрітись з Настьою\n3. Приготувати вечерю.");
                break;
            case "п'ятниця":
                System.out.println("1. Прибрати квартиру\n2. Попрати\n3. Сходити за продуктами в приготувати вечерю");
                break;
            case "субота":
                System.out.println("1. З'їздити до бабусі\n2. Сходити ввечері на боулінг з друзями");
                break;
            case "неділя":
                System.out.println("1.Провести день з чоловіком");
            default:
                System.out.println("Такого дня немає.");
        }
    }

    private static void first55Elements() {
        System.out.println(" 3.");
        for (int i = 1; i < 55; i = i + 2) {
            System.out.println(i);
        }
    }

    private static void less5Elements() {
        System.out.println(" 4.");
        for (int b = 90; b > 5; b = b - 5) {
            System.out.println(b);
        }
    }

    private static void evenOdd() {
        System.out.println(" 5.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть число n : ");
        int n = sc.nextInt();

        if (n % 2 != 0) {
            System.out.println("Ваше число непарне.");
        } else {
            System.out.println("Ваше число парне.");
        }
    }

    private static void closestToTen() {
        System.out.println(" 6.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть число a: ");
        double a = sc.nextDouble();
        System.out.println("Введіть число b: ");
        double b = sc.nextDouble();

        double toTen1 = abs(a - 10);
        double toTen2 = abs(b - 10);
        if (toTen1 > toTen2) {
            System.out.println("Число b ближче до 10 = " + b);
        } else if (toTen1 < toTen2) {
            System.out.println("Число a ближче до 10 = " + a);
        }
    }

    private static void maxMinElements() {
        System.out.println(" 7.");
        int[] numbers = {15, 2, 25, -84, -55, 569, 36, 574, -66, 0, 18};

        int minElements = numbers[0];
        int maxElements = numbers[0];

        for (int number : numbers) {
            if (number < minElements) {
                minElements = number;
            }
            if (number > maxElements) {
                maxElements = number;
            }
        }
        System.out.println("Min = " + minElements);
        System.out.println("Max = " + maxElements);
    }
}
