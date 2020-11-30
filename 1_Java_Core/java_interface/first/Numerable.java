package java_interface.first;


import java_interface.Divide;
import java_interface.Minus;
import java_interface.Multiply;
import java_interface.Plus;

public interface Numerable extends Plus, Minus, Multiply, Divide {

    @Override
    double plus(double a, double b);

    @Override
    double minus(double a, double b);

    @Override
    double multiply(double a, double b);

    @Override
    double divide(double a, double b);
}
