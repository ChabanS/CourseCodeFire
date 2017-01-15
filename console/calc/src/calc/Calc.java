/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.Scanner;

/**
 *
 * @author Sergey
 */
public class Calc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        double a;
//        double b;
//        String mathSymbol;
        double result;
        Result calc = new Result();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Введите число А : ");
        calc.setA(keyboard.nextDouble());
        System.out.print("Введите математический символ (+,-,*,/): ");
        calc.setMathSymbol(keyboard.next());
        System.out.print("Введите число B : ");
        calc.setB(keyboard.nextDouble());

        System.out.println("Результат математического вычисления :" + calc.getResult());

    }

}
