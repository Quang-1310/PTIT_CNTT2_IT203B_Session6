package BTTH;

public class SystemSellTicket {
    public static int totalTicket = 10;

    public synchronized static boolean sellTicket(String tenQuay) {
        if (totalTicket > 0) {
            totalTicket--;
            System.out.printf("%s đã bán được 1 vé. Số vé còn lại: %d\n", tenQuay, totalTicket);
            return true;
        } else {
            return false;
        }
    }
}