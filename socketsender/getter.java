package socketsender;
import java.io.*;
import java.net.*;

public class getter {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> {//Seperate server lambda
            int port = 5000;//Port number :)
            System.out.println("Listening on port " + port + "...");
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    try (Socket clientSocket = serverSocket.accept(); //repeatedly accept new things 
                         BufferedReader reader = new BufferedReader( //add said thing to a buffer
                             new InputStreamReader(clientSocket.getInputStream()))) {//read the buffer of things
                        System.out.println("Client connected: " + clientSocket.getInetAddress());//Say a new client has connected
                        String line;
                        while ((line = reader.readLine()) != null) {
                            //print the line of the stuff that was read from the buffer
                            main.addMessage(line);
                            
                        }
                        System.out.println("Client disconnected.");//say bye!
                    }
                }
            } catch (IOException e) { //no connection
                e.printStackTrace();//woops
            }
        });


        serverThread.setDaemon(true);//now do it!
        serverThread.start();
    }
}