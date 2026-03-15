package Kha_Gioi;

import java.util.Random;

public class BookingCounter implements Runnable{
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB, int soldCount) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.soldCount = soldCount;
    }

    public String getCounterName() {
        return counterName;
    }

    public TicketPool getRoomA() {
        return roomA;
    }

    public TicketPool getRoomB() {
        return roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run(){
        while(true){
            Random rand = new Random();
            int randomNumber = rand.nextInt(2) + 1;
            Ticket ticket = null;
//            if(roomA.getTickets().isEmpty() && roomB.getTickets().isEmpty()){
//                break;
//            }
            if(randomNumber == 1){
                try {
                    ticket = roomA.sellTicket();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ticket == null){
                    try {
                        ticket = roomB.sellTicket();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else{
                try {
                    ticket = roomB.sellTicket();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ticket == null){
                    try {
                        ticket = roomA.sellTicket();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (ticket != null) {
                soldCount++;
                System.out.printf("%s đã bán vé %s\n", counterName, ticket.getTicketId());
            }
        }

//        while (true) {
//
//            if(roomA.getTickets().isEmpty() && roomB.getTickets().isEmpty()){
//                break;
//            }
//
//            sellCombo();
//
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                break;
//            }
//        }
    }

//    public synchronized void returnTicket(Ticket ticket, TicketPool room){
//        if(ticket != null){
//            room.getTickets().add(ticket);
//        }
//    }
//
//    public void sellCombo(){
//        synchronized (roomA){
//            synchronized (roomB){
//                Ticket tA = roomA.sellTicket();
//                Ticket tB = roomB.sellTicket();
//                if (tA != null && tB != null) {
//                    soldCount++;
//                    System.out.printf("%s bán COMBO thành công: %s & %s\n",counterName, tA.getTicketId(), tB.getTicketId());
//                } else {
//                    if(tA != null){
//                        returnTicket(tA, roomA);
//                    }
//                    else {
//                        returnTicket(tB, roomB);
//                    }
//                    System.out.println(counterName + ": Thiếu vé, hủy giao dịch.");
//                }
//            }
//        }
//    }
}
