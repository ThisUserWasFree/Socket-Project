package socketsender;
import java.util.ArrayList;

public class main {
    static ArrayList<String> messagesinHolding = new ArrayList<String>();

    public static void main(String[] args) {
        getter.main(args);
        while (true) { 
            if (messagesinHolding.size() > 0) {
                System.out.println(messagesinHolding);
                messagesinHolding.remove(0);
            }
        }
        
    }
    public static void addMessage(String message) {
        messagesinHolding.add(message);
        System.out.println(messagesinHolding);
}
    
}


