package Kha_Gioi;

import java.util.ArrayList;
import java.util.List;

public class MainKha_Gioi {
    public static void main(String[] args) throws InterruptedException {
        List<Ticket> listA = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            listA.add(new Ticket(String.format("A-%03d", i), "A", false));
        }
        TicketPool poolA = new TicketPool("Phòng A", listA);

        List<Ticket> listB = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            listB.add(new Ticket(String.format("B-%03d", i), "B", false));
        }
        TicketPool poolB = new TicketPool("Phòng B", listB);

        BookingCounter b1 = new BookingCounter("Quầy 1", poolA, poolB, 0);
        BookingCounter b2 = new BookingCounter("Quầy 2", poolA, poolB, 0);

        TicketSupplier ts1 = new TicketSupplier(poolA, poolB, 3, 3000, 2);

        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b2);
        Thread t3 = new Thread(ts1);

        t1.start();
        t2.start();
        t3.start();

        t3.join();
        t1.join();
        t2.join();

        System.out.println("----------------------------");
        System.out.println("KẾT THÚC CHƯƠNG TRÌNH");
        System.out.println("Quầy 1 bán được: " + b1.getSoldCount() + " vé");
        System.out.println("Quầy 2 bán được: " + b2.getSoldCount() + " vé");
        System.out.println("Vé còn lại phòng A: " + poolA.getTickets().size());
        System.out.println("Vé còn lại phòng B: " + poolB.getTickets().size());

//        Thread t4 = new Thread(b1);
//        t4.start();
    }
}
