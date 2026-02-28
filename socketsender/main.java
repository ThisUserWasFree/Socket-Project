package socketsender;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    static ArrayList<String> messagesinHolding = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Starting getter thread.");
        Thread getterThread = new Thread(() -> {
            getter.main(args);
        });
        getterThread.start();
        System.out.println("Started getter thread.");
        

        while (true) {
            if (messagesinHolding.size() > 0) {
                System.out.println(messagesinHolding.get(0));
                messagesinHolding.remove(0);
            }
            try {
                System.out.println("Press enter for next message...");
                System.in.read(); // waits until enter is pressed
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    public static void addMessage(String message) {
        messagesinHolding.add(message);
        //System.out.println(messagesinHolding);
}
    
}


