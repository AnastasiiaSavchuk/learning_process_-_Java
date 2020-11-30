package thread;

import java.util.Scanner;

public class MyThread extends Thread {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("Enter how mani Fibonacci numbers you want to see : ");
        int number = scanner.nextInt();
        int n0 = 1, n1 = 1, n2;
        for (int i = 0; i < number; i++) {
            n2 = n0 + n1;
            System.out.print(n0 + " ");
            n0 = n1;
            n1 = n2;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

