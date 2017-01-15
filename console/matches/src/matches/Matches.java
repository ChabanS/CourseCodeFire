package matches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sergey
 */
public class Matches {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final int PLAYER = 2;
    public static final int PEOPLE = 1;
    public static final int COMPUTER = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        int n = 13; //count matches

        while (true) {
            Menu();
            int menuChoice = Integer.parseInt(reader.readLine());
            if (menuChoice == 1) {
                PrintMatches(n);
                Logical.gameLogical(n, reader);
            } else if (menuChoice == 2) {
                break;
            } else {
                System.out.println("Incorect choise number. Please try again.");
            }
        }
    }

    public static void Menu() {
        System.out.println("1. Play game.");
        System.out.println("2. Exit game.");
        System.out.print("Make your choice:");
    }

    public static void PrintMatches(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" | ");
        }
        System.out.println();
    }
}
