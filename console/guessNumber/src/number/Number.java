package number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Sergey
 */
public class Number {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 25;
        int progress = 5;
        int win = 0;
        int lost = 0;

        while (true) {
            Menu();
            int number = randomNumber(n);
            if (userInput(reader) == 1) {
                if (gameLogical(progress, reader, number, n)) {
                    n = n * 2;
                    progress = progress + 1;
                    win++;
                } else {
                    n = n / 2;
                    lost++;
                }
            } else {
                break;
            }
        }
        System.out.println("You finished game. You WIN - " + win + ", LOST -" + lost + ".");
    }

    public static void Menu() {
        System.out.println("1. Play game.");
        System.out.println("2. Exit game.");
        System.out.print("Make your choice:");
    }

    public static boolean gameLogical(int progress, BufferedReader reader, int number, int n) throws NumberFormatException, IOException {
        boolean result = false;
        for (int i = 0; i < progress; i++) {
            System.out.print("Input number [0-" + n + "] ");
            int userNumber = userInput(reader);
            if (check(userNumber, number)) {
                System.out.println("You WIN :)");
                result = true;
                break;
            } else if (i == progress - 1) {
                System.out.println("You LOST :)");
            }
        }
        return result;
    }

    public static int userInput(BufferedReader reader) throws NumberFormatException, IOException {
        String user = reader.readLine();
        int userNumber = Integer.parseInt(user);
        return userNumber;
    }

    public static boolean check(int userNumber, int number) {
        if (userNumber == number) {
            return true;
        } else if (userNumber > number) {
            System.out.println("This number is greater.");
        } else {
            System.out.println("This number is less.");
        }
        return false;
    }

    public static int randomNumber(int n) {
        Random random = new Random();
        int number = random.nextInt(n);
        return number;
    }
}
