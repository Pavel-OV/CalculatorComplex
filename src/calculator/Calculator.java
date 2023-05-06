package calculator;

import calculator.complexNumber.Digits;

public class Calculator < N extends Digits> {

   

    public N amount (N arg1, N arg2){
        N sum = (N) arg1.sum(arg2);
        return sum;
    }

    public N subtraction (N arg1, N arg2){
        N sub = (N) arg1.subtraction(arg2);
        return sub;
    }
    
    public N multiplication (N arg1, N arg2){
        N mult = (N) arg1.multiplication(arg2);
        return mult;
    }

}
