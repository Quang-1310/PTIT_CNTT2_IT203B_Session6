package thread.runnable;

public class RunnableCountOdd implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            try{
                if(i % 2 == 1){
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                System.out.println("Lỗi");
            }

        }
    }
}
