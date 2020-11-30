package java_colection.store_map_jenerics.dto;

import java.util.Objects;

public class Price {

    private String model;
    private int cost;

    public Price(String model, int cost) {
        this.model = model;
        this.cost = cost;
    }

    public Price() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return cost == price.cost &&
                model.equals(price.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, cost);
    }

    @Override
    public java.lang.String toString() {
        return model + " : cost = " + cost;
    }
}
