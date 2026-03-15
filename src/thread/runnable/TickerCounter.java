package thread.runnable;

public class TickerCounter {
    public static int totalTicket = 10;

    public static synchronized void sellTicket(){
        if (totalTicket > 0){
            totalTicket--;
        }
    }
}
