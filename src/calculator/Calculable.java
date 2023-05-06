package calculator;

import calculator.complexNumber.Digits;

public interface Calculable <T extends Digits> {
    T subtraction(T arg2);
    T multiplication (T arg2);
    T sum (T arg2);
    T division (T arg2);
    T sqrt ();
    T exp ();
}
