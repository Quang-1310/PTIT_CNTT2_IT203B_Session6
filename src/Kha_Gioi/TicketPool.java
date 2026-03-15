package Kha_Gioi;

import java.util.List;

public class TicketPool {
    private String roomName;
    List<Ticket> tickets;

    public TicketPool(String roomName, List<Ticket> tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public synchronized Ticket sellTicket() throws InterruptedException {
        if(tickets.isEmpty()){
//            return null;
            System.out.printf("Hết vé %s đang chờ ....\n",  roomName);
            wait();
        }
        Ticket ticket = tickets.get(0);
        tickets.remove(0);
        return ticket;
    }

    public synchronized void addTickets(int count){
        for (int i = 1; i <= count; i++) {
            String newId = String.format("%03d", 10 + i);
            tickets.add(new Ticket(newId, this.roomName, false));
        }
        notifyAll();
        System.out.printf("Nhà cung cấp: Đã thêm %d vé vào %s\n", count, roomName);
    }


}
