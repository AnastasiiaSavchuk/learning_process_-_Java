package java_core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainIntegerArrayList {

    public static void main(String[] args) {

        ArrayList<Integer> integer = new ArrayList<>();
        Random random = new Random();

        System.out.println("Array is unsorted : ");
        for (int i = 0; i < 10; i++) {
            integer.add(random.nextInt(1254));
            System.out.println(integer.get(i));
        }
        for (int i = 0; i < integer.size(); i++) {
            for (int j = 0; j < integer.size() - i - 1; j++) {
                if ((integer.get(j)) > (integer.get(j + 1))) {
                    Collections.swap(integer, j, j + 1);
                }
            }
        }
        System.out.println("\nArray in the growth slowdown :");
        for (Integer s : integer) {
            System.out.println(s);
        }

        for (int i = 0; i < integer.size(); i++) {
            for (int j = 0; j < integer.size() - i - 1; j++) {
                if ((integer.get(j)) < (integer.get(j + 1))) {
                    Collections.swap(integer, j, j + 1);
                }
            }
        }
        System.out.println("\nArray in the falling down :");
        for (Integer s : integer) {
            System.out.println(s);
        }
    }
}