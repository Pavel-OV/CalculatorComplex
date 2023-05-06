package calculator.actionLog;

import java.util.Stack;

import calculator.Calculable;

public class Сounting {
     Stack<Calculable> cash;

    public Сounting() {
        this.cash = new Stack<>();
    }

    public Calculable fromCash(){
        return this.cash.pop();
    }

    public Calculable look(){
        return this.cash.lastElement();
    }

    public void toCash(Calculable item){
        this.cash.push(item);
    }

    
}
