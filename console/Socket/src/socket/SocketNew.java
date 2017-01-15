package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Sergey
 */
public class SocketNew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        double a = 2;
        double b = 3;

        try (Socket socket = new Socket("192.168.1.117", 12345)) 
        {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            outputStream.writeDouble(a);
            outputStream.writeDouble(b);
            System.out.println(inputStream.readDouble());
        }

    }

}
