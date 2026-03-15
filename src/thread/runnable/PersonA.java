package thread.runnable;

public class PersonA implements Runnable{
    @Override
    public void run(){
        while(TickerCounter.totalTicket > 0){
            try{
                System.out.println("A mua đc vé");
                TickerCounter.sellTicket();
                Thread.sleep(1000);
            }catch(InterruptedException ie){
                System.out.println("Lỗi");
            }
        }
    }
}
