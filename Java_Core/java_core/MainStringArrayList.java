package java_core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainStringArrayList {

    public static void main(String[] args) {
        System.out.println("Enter your 5 words : ");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String s = scanner.next();
            list.add(s);
        }

        System.out.println("\nArrayList is unsort : ");
        for (String s : list) {
            System.out.println(s);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if ((list.get(j)).length() > (list.get(j + 1).length())) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }

        System.out.println("\nArrayList in the growth slowdown :");
        for (String s : list) {
            System.out.println(s);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if ((list.get(j)).length() < (list.get(j + 1).length())) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        System.out.println("\nArrayList in the falling down :");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
