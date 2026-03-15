package BTTH;

public class Quay implements Runnable {
    private String tenQuay;

    public Quay(String tenQuay) {
        this.tenQuay = tenQuay;
    }

    @Override
    public void run() {
        while (true) {
            boolean coVeDeBan = SystemSellTicket.sellTicket(this.tenQuay);
            if (!coVeDeBan) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}