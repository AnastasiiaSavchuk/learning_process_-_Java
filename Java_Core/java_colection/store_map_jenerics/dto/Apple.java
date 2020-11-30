package java_colection.store_map_jenerics.dto;

import java.util.Objects;

public class Apple<S> {

    private S Type;

    public Apple(S type) {
        Type = type;
    }

    public Apple() {
    }

    public S getType() {
        return Type;
    }

    public void setType(S type) {
        Type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Type.equals(apple.Type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Type);
    }

    @Override
    public String toString() {
        return "Apple type : " + Type + " ";
    }
}
