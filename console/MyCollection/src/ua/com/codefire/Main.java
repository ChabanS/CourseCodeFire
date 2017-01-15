package ua.com.codefire;

import java.util.Arrays;
import ua.com.codefire.task.MyListImpl;

/**
 * https://gist.github.com/
 * @author codefire
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyListImpl myListImpl = new MyListImpl();
        for (int i = 0; i < 10; i++) {
            myListImpl.add(i);
        }
        myListImpl.add(3);
        myListImpl.add(12);
        
        
        System.out.println(Arrays.toString(myListImpl.getAll()));
        System.out.println(Arrays.toString(myListImpl.sort()));
        System.out.println(Arrays.toString(myListImpl.shuffle()));
        System.out.println(Arrays.toString(myListImpl.reverse()));
        
        
    }
    
    
}
