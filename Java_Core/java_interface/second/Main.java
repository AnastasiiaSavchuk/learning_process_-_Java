package java_interface.second;

public class Main {

    public static void main(String[] args) {

        MyCalculatorImpl myCalculator = new MyCalculatorImpl();

        System.out.println(myCalculator.plus(18.6, 6.17));
        System.out.println(myCalculator.minus(17.5, 2.1));
        System.out.println(myCalculator.multiply(104.6, 18.169));
        System.out.println(myCalculator.divide(1254.5, 63));
    }
}
