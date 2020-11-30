package java_colection.social_inner_class.dto;

public class Account<T> {

    private T id;
    private double sum;

    public Account(T id, double sum) {
        this.id = id;
        this.sum = sum;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "java_colection.social_inner_class.dto.Account id : " + id + ", sum : " + sum;
    }
}
