package thread.runnable;

public class MainRunable {
    public static void main(String[] args) throws InterruptedException {
//        Thread threadCountEven = new Thread(new RunableCountEven());
//        Thread threadCountOdd = new Thread(new RunnableCountOdd());
//        threadCountEven.start();
//        threadCountEven.join();
//        threadCountOdd.start();
//        threadCountOdd.join();
        Thread person1 = new Thread(new PersonA());
        Thread person2 = new Thread(new PersonB());
        person2.start();
        person1.start();
    }
}
