package recursy;

/**
 *
 * @author Sergey
 */
public class Recursy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 1; i < 10; i++) {
            System.out.println(fib(i));
        }

    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

}
