package java_OOP.rectangle;

public class MainRectangle {

    public static void main(String[] args) {

        System.out.println(" 4. Rectangle.");
        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(15);
        rectangle.setLength(30);

        System.out.println(rectangle.toString());
        rectangle.getPerimeter();
        rectangle.getSquare();

        Rectangle rectangle1 = new Rectangle(25, 40);

        System.out.println(rectangle1.toString());
        rectangle1.getSquare();
        rectangle1.getPerimeter();

    }

}
