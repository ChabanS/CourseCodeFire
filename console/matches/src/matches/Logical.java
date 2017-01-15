package matches;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Sergey
 */
public class Logical {

    public static void gameLogical(int n, BufferedReader reader) throws IOException, NumberFormatException {
        if ((new Random().nextInt(Matches.PLAYER) + 1) == Matches.PEOPLE) {
            firstPlayer(n, reader);
        } else {
            firstComputer(n, reader);
        }
    }

    public static void firstComputer(int n, BufferedReader reader) throws IOException, NumberFormatException {
        while (true) {
            n = stepComputer(n);
            if (whoWin(n, Matches.COMPUTER)) {
                break;
            }
            n = stepUser(n, reader);
            if (whoWin(n, Matches.PEOPLE)) {
                break;
            }
        }
    }

    public static void firstPlayer(int n, BufferedReader reader) throws NumberFormatException, IOException {
        while (true) {
            n = stepUser(n, reader);
            if (whoWin(n, Matches.PEOPLE)) {
                break;
            }
            n = stepComputer(n);
            if (whoWin(n, Matches.COMPUTER)) {
                break;
            }
        }
    }

    public static int stepComputer(int n) {
        int computerNumber = 0;
        if ((n % 4) > 0) {
            computerNumber = n % 4;
        } else {
            computerNumber = (new Random().nextInt(3) + 1);
        }
        System.out.println("Computer enter the number - " + computerNumber);
        n -= computerNumber;
        return n;
    }

    public static int stepUser(int n, BufferedReader reader) throws NumberFormatException, IOException {
        System.out.print("Enter the number of matches[1-3]:");
        int userNumber = Integer.parseInt(reader.readLine());
        while (userNumber > 4 && userNumber < 0) {
            System.out.println("You enter incorect number, please enter again.");
            userNumber = Integer.parseInt(reader.readLine());
        }
        n -= userNumber;
        return n;
    }

    public static boolean whoWin(int n, int player) {
        if (n == 0) {
            if (player == Matches.PEOPLE) {
                System.out.println("You WIN.");
            } else {
                System.out.println("Computer WIN.");
            }
            return true;
        } else {
            Matches.PrintMatches(n);
        }
        return false;
    }
}
