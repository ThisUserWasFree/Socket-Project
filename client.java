import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        int port = 5000;

        System.out.println("Listening on port " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) { //repeatedly tries to accept new connections 
                try (Socket clientSocket = serverSocket.accept(); //When a sender connects, it accepts the connection
                     BufferedReader reader = new BufferedReader( //buffers the input stream
                         new InputStreamReader(clientSocket.getInputStream()))) { //reads the input stream

                    System.out.println("Client connected: " + clientSocket.getInetAddress()); 

                    String line; //reads the lines sent
                    while ((line = reader.readLine()) != null) { //while there are lines to read, it prints them
                        System.out.println("Received: " + line);
                    }

                    System.out.println("Client disconnected.");
                }
            }
        }
    }
}