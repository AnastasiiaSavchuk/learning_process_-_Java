package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RunnableTread implements Runnable {

    @Override
    public synchronized void run() {
        List<Integer> list = fibonacci();
        Collections.reverse(list);
        for (Integer integer : list) {
            System.out.println(integer);
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Integer> fibonacci() {
        List<Integer> fib = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a count of numbers Fibonacci");
        int number = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c = 0;
        while (c < number) {
            c = a + b;
            a = b;
            b = c;
            fib.add(c);
        }
        return fib;
    }
}





