package java_OOP.circle;

import java.util.Scanner;

public class Circle {

    public double radius;
    public double diameter;
    double array, length;

    public Circle() {
    }

    public Circle(double radius, double diameter) {
        Scanner sc = new Scanner(System.in);
        this.radius = radius;
        this.diameter = 2 * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void getArray() {
        array = (Math.PI * Math.sqrt(diameter)) / 4;
        System.out.println("Array Circle = " + array);
    }

    public void getLength() {
        length = Math.PI * 2 * radius;
        System.out.println("Length Circle = " + length);
    }

    @Override
    public String toString() {
        return "Circle : " + "radius = " + radius + ", diameter = " + diameter + '.';
    }
}
