package java_colection.parchase_list.dto;

import java.util.Objects;

public class Purchase implements Comparable<Purchase> {

    private String name;
    private int count;

    public Purchase(String name, int count) {
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
    public String toString() {
        return name + ", count : " + count + ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return count == purchase.count &&
                name.equals(purchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }

    @Override
    public int compareTo(Purchase purchase) {
        int result = this.name.compareTo(purchase.name);
        if (result == 0) {
            result = this.count - purchase.count;
        }
        return result;
    }
}
