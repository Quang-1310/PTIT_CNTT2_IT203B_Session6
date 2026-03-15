package Kha_Gioi;

public class TicketSupplier implements Runnable{
    private TicketPool roomA;
    private TicketPool roomB;
    private int supplyCount;
    private int interval;
    private int rounds;

    public TicketSupplier(TicketPool roomA, TicketPool roomB, int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    public TicketPool getRoomA() {
        return roomA;
    }

    public TicketPool getRoomB() {
        return roomB;
    }

    public int getSupplyCount() {
        return supplyCount;
    }

    public int getInterval() {
        return interval;
    }

    public int getRounds() {
        return rounds;
    }

    @Override
    public void run(){
        for(int i = 0; i < rounds; i++){
            try{
                Thread.sleep(interval);
                roomA.addTickets(supplyCount);
                roomB.addTickets(supplyCount);
            }catch(InterruptedException ie){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
