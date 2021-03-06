package java_core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_fundamentals2 {

    public static void main(String[] args) {

        seventeenElements();
        reverseElements();
        multiplicationTable();
        sumElements();
        recognizeElements();
        reIntroduction();
        solutionExample();
        myPassword();
        enteringElements();
        oneHundredElements();
        duplicateElement();
        fibElements();
        maxMinElements();
        plusElements();
        sortElements();
    }

    //1
    public static void seventeenElements() {
        System.out.println(" № 1.");
        for (int i = 1; i <= 17; i++) {
            System.out.println(i);
        }
    }

    //2
    public static void reverseElements() {
        System.out.println(" № 2.");
        for (int i = 17; i >= 1; i--) {
            System.out.println(i);
        }
    }

    //3
    public static void multiplicationTable() {
        System.out.println(" № 3.");
        int i = 5;
        for (int n = 1; n <= 10; n++) {
            System.out.println(i + " * " + n + " = " + i * n);
        }
    }

    //4
    public static void sumElements() {
        System.out.println(" № 4.");
        Scanner scn = new Scanner(System.in);
        System.out.println("Введітьваше числo k : ");
        int k = scn.nextInt();
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += i;
        }
        System.out.println("Sum = " + sum);
    }

    //5
    public static void recognizeElements() {
        System.out.println(" № 5.");
        Scanner scn = new Scanner(System.in);
        System.out.println("Введітьваше числo l : ");
        int l = scn.nextInt();

        if (l < 0) {
            System.out.println("Ваше число від'ємне.");
        } else if (l == 0) {
            System.out.println("Ваше число 0.");
        } else {
            System.out.println("Ваше число додатнє.");
        }
    }

    //6
    public static void reIntroduction() {
        System.out.println(" № 6.");
        Scanner scn = new Scanner(System.in);
        System.out.println("Введітьваше числo 0 : ");
        int number = scn.nextInt();

        while (number != 0) {
            System.out.println("Введітьваше числo 0 : ");
            number = scn.nextInt();
        }
    }

    //7
    public static void solutionExample() {
        System.out.println(" № 7.");
        System.out.println("Розв'яжіть рівняння : \n\n84 * 5 =\n");
        Scanner scn = new Scanner(System.in);
        System.out.println("Введіть вашу відповідь : ");
        int answer = scn.nextInt();

        while (answer != 420) {
            System.out.println("Введіть вашу відповідь : ");
            answer = scn.nextInt();
        }
    }

    //8
    public static void myPassword() {
        System.out.println(" № 8.");
        Scanner scn = new Scanner(System.in);
        System.out.println("Введіть ваш проль : ");
        String pass = scn.next();

        switch (pass) {
            case "pass123":
                System.out.println("Пароль вірний.");
                break;
            case "admin":
                System.out.println("Ви увійшли як адміністратор");
                break;
            default:
                System.out.println("Пароль невірний.");
        }
    }

    //9
    public static void enteringElements() {
        System.out.println(" № 9.");
        Scanner scn = new Scanner(System.in);
        System.out.println(" Скільки кількість елементів масиву : ");
        int size = scn.nextInt();// Читаем с клавиатуры размер массива и записываем в size
        int[] array = new int[size];// Создаём массив int размером в size
        System.out.println("Введіть елементи в масив :");//Пройдёмся по всему массиву, заполняя его

        for (int i = 0; i < size; i++) {
            array[i] = scn.nextInt();
        }
        System.out.println("Ваш масив : "); // Выводим на экран, полученный массив
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
    }

    //10
    public static void oneHundredElements() {
        System.out.println(" № 10.");
        int[] number = new int[1000];

        for (int i = 1; i <1000; i++) {
            number[i] = i;
            if (number[i] % 14 == 0) {
                System.out.print(" " + number[i] + "");
            }
        }
        System.out.println();
    }

    //11
    public static void duplicateElement() {
        Integer[] a = {3, 5, 26, 8, 3, 2, 6, 5, 2, 15, 2, 6, 18, 9};
        int n = a.length;
        for (int x = 0; x < a.length; x++) {
            for (int y = x + 1; y < a.length; y++) {
                if (a[x].equals(a[y])) {
                    System.out.print(a[y] + " ");
                    break;
                }
            }
        }
        System.out.println();
        Set<Integer> deleter = new HashSet<>(Arrays.asList(a));
        System.out.println(deleter);
    }

    //12
    public static void fibElements() {
        System.out.println(" № 12.");
        int n0 = 1, n1 = 1, n2;
        System.out.print("Послідовність Фібоначі = " + n0 + " " + n1 + " ");
        for (int i = 0; i < 8; i++) {
            n2 = n0 + n1;
            System.out.print(+n2 + " ");
            n0 = n1;
            n1 = n2;
        }
        System.out.println();
    }

    //13
    public static void maxMinElements() {
        System.out.println(" № 13.");
        int[] numbers = {8, 5, 10, -4, -985, 569, 86, 74, -6, 0, 111118};

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

    //14
    public static void plusElements() {
        System.out.println(" № 14.");
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {6, 7, 8, 9, 10};
        int[] C = new int[5];

        C[0] = A[0] + B[0];
        C[1] = A[1] + B[1];
        C[2] = A[2] + B[2];
        C[3] = A[3] + B[3];
        C[4] = A[4] + B[4];

        for (int x = 0; x < 5; x++) {
            System.out.print(A[x] + " ");
        }
        System.out.println();
        for (int y = 0; y < 5; y++) {
            System.out.print(B[y] + " ");
        }
        System.out.println();
        System.out.println("С = " + C[0] + " " + C[1] + " " + C[2] + " " + C[3] + " " + C[4]);
    }

    //15
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            int tmp;
            tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    public static void sortElements() {
        System.out.println(" № 15.");
        int[] nums = {81, 5, 14, 32, 55, 821, 94, 521, 72, 845, 123, 37};
        sort(nums);
        for (int num : nums) System.out.println(num);
    }
}
