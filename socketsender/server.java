package socketsender;
import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            writer.println("Hello, server!");
            writer.println("This is a second string.");
            writer.println("Goodbye!");
        }
    }
}