package socketsender;
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
            System.out.println("Waiting for messages...");
            System.out.println(messagesinHolding);
            try {
                Thread.sleep(100); // check every 100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (messagesinHolding.size() > 0) {
                System.out.println(messagesinHolding);
                //messagesinHolding.remove(0);
            }
        }
        
    }
    public static void addMessage(String message) {
        messagesinHolding.add(message);
        //System.out.println(messagesinHolding);
}
    
}


