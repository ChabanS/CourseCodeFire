/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

import java.util.Scanner;
import java.util.concurrent.Exchanger;

/**
 *
 * @author Sergey
 */
public class Currency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ecxhange e = new Ecxhange();

        Scanner s = new Scanner(System.in);
        System.out.print("Введите сумму в USD : ");
        e.setUsd(s.nextDouble());

        System.out.print("Введите курс USD к UAH : ");
        e.setUah(s.nextDouble());

        System.out.println("Сумма в UAH = " + e.exchange() + " грн.");
    }

}
