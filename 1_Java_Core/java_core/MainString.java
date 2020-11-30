package java_core;

import java.util.Scanner;

public class MainString {

    public static void main(String[] args) {

        String str = "I like Java !!!";

        System.out.println("                 " + str);
        System.out.println("1. Last line character : " + str.charAt(+13));
        System.out.println("2. Ending with the series '!!!' of characters : " + str.endsWith("!!!"));
        System.out.println("3. Starting with the series 'I like' of characters : " + str.startsWith("I like"));
        System.out.println("4. Check for a 'JAVA' row :  " + str.contains("Java"));
        System.out.println("5. Find the character 'JAVA' position : " + str.indexOf("Java"));
        System.out.println("6. Replacement of characters A and O : " + str.replace('a', 'o'));
        System.out.println("7. All characters are large : " + str.toUpperCase());
        System.out.println("8. All characters are small : " + str.toLowerCase());
        System.out.println("9. Cut the row 'JAVA' : " + str.substring(7, 11));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your line :");
        String nextStr = sc.nextLine();
        printWordsWithStartCharO(nextStr);
    }

    public static void printWordsWithStartCharO(String str) {
        String[] array = str.split(" ");
        for (String startA : array) {
            if (startA.length() % 2 == 0 && startA.startsWith("a")) {
                System.out.println(startA);
            } else {
                System.out.println("Your word's don't start with 'A'!");
            }
        }
    }
}
