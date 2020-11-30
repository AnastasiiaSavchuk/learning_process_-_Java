package java_OOP.circle;

public class MainCircle {

    public static void main(String[] args) {

        System.out.println(" 5. Circle.");
        Circle circle = new Circle(14.5, 0);

        System.out.println(circle.toString());
        circle.getArray();
        circle.getLength();
    }
}
