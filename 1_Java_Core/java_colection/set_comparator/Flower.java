package java_colection.set_comparator;

import java.util.Objects;

public class Flower implements Comparable<Flower> {

    private String name;
    private int count;

    public Flower(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return count == flower.count &&
                name.equals(flower.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    @Override
    public String toString() {
        return "Flower name : " + name + ", count = " + count;
    }

    @Override
    public int compareTo(Flower flower) {
        return this.count - flower.count;
    }
}
