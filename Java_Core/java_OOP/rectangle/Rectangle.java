package java_OOP.rectangle;

public class Rectangle {

    private int width;
    private int length;
    int square, perimeter;

    // default
    public Rectangle() {
    }

    // custom constructor with parameters
    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    //custom constructor without parameters
    public void Rectangle() {
        this.width = 25;
        this.length = 40;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void getSquare() {
        square = width * length;
        System.out.println("Square = " + square);
    }

    public void getPerimeter() {
        perimeter = 2 * (width + length);
        System.out.println("Perimeter = " + perimeter);
    }


    @Override
    public String toString() {
        return "Rectangle : " + "width = " + width +", length = " + length + '.';
    }
}
