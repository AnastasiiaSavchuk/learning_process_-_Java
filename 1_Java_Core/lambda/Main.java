package lambda;

public class Main {

    public static void main(String[] args) {

        System.out.println("Max number is : " + maxValue().number(22, 23, 8));
        System.out.println("Medium number is :" + mediumValue().number(85, 2, 3));
    }

    private static Number maxValue() {
        return ((a, b, c) -> {
            if (a > b && a > c) return a;
            else if (b > a && b > c) return b;
            else return c;
        });
    }

    private static Number mediumValue() {
        return ((a, b, c) -> (a + b + c) / 3);
    }
}
