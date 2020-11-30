package java_exception.service.impl;

import java_exception.service.MathService;

public class MathServiceImpl implements MathService {

    @Override
    public double plus(double a, double b) {
        return a + b;
    }

    @Override
    public double minus(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        return a / b;
    }
}
