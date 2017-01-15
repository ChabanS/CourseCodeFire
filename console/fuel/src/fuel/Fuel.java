package fuel;

import java.util.Scanner;

/**
 *
 * @author Sergey
 */
public class Fuel {

    public static void main(String[] args) {

        Rate rate = new Rate();
        Scanner s = new Scanner(System.in);
        System.out.print("Введите количество километров : ");
        rate.setKm(s.nextDouble());

        System.out.print("Введите средний расход топлива : ");
        rate.setRate(s.nextDouble());

        System.out.println("Для прохождения " + rate.getKm()
                + "км пути требуется " + rate.multiplication() + " литров топлива.");
    }
}
