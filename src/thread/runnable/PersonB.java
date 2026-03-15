package thread.runnable;

public class PersonB implements Runnable{
    @Override
    public void run() {
        while (TickerCounter.totalTicket > 0) {
            try {
                System.out.println("B mua được vé");
                TickerCounter.sellTicket();
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Lỗi");
            }
        }
    }
}
