package calculator;

import java.util.Scanner;

import calculator.actionLog.Logger;
import calculator.actionLog.Сounting;
import calculator.complexNumber.ComplexNumber;
import calculator.complexNumber.Digits;
import calculator.complexNumber.NumberEntering;

public class GraphicConsole {
    NumberEntering num = new NumberEntering();
    Calculator calc = new Calculator();
    Logger logger = new Logger();
    Сounting temp = new Сounting();

    public void run() {
        System.out.println("Калькулятор комплексных чисел. Для начала работы набирите CN(cn)");
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Набирите команду: ");
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT)
                    return;
                switch (com) {
                    case CN:
                        createComplNum();
                        break;
                    case PLUSE:
                        sum();
                        break;
                    case MINUSE:
                        subtraction();
                        break;
                    case MULT:
                        multiplication();
                        break;
                    case LOG:
                        showLog();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showLog() {
        System.out.println(logger.printLogs());
    }

    private void log(String text) {
        logger.log(text);
    }

    public ComplexNumber createComplNum() {
        int ind = Integer.parseInt(prompt("Индекс для комплекса = "));
        int mat = Integer.parseInt(prompt("Материальная часть комплекса ="));
        int img = Integer.parseInt(prompt("Мнимая часть комплекса i="));
        ComplexNumber complex = num.createComplexNumber(ind, mat, img);
        log(complex.toString());
        temp.toCash(complex);
        return complex;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

   

    public void sum() {
        if (temp.look() instanceof ComplexNumber) {
            System.out.println("Cоздадим второе комплексное число.");
            log("+");
            // Digits res = temp.fromCash().sum(this.createComplNum());
            Digits res = calc.amount((Digits) temp.fromCash(), this.createComplNum());
            log("=");
            log(res.toString());
            temp.toCash(res);
            System.out.println(res);
        }
    }

    private void subtraction() {
        if (temp.look() instanceof ComplexNumber) {
            System.out.println("Cоздадим второе комплексное число.");
            log("-");
            // Digits res = temp.fromCash().subtraction(this.createComplNum());
            Digits res = calc.subtraction((Digits) temp.fromCash(), this.createComplNum());
            temp.toCash(res);
            log("=");
            log(res.toString());
            System.out.println(res);
        }
    }

    private void multiplication() {
        if (temp.look() instanceof ComplexNumber) {
            System.out.println("Cоздадим второе комплексное число.");
            log("*");
            // Digits res = temp.fromCash().multiplication(this.createComplNum());
            Digits res = calc.multiplication((Digits) temp.fromCash(), this.createComplNum());
            temp.toCash(res);
            log("=");
            log(res.toString());
            System.out.println(res);
        }
    }
}