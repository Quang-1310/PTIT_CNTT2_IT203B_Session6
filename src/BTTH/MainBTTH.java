package BTTH;

public class MainBTTH {
    public static void main(String[] args) {
        Thread q1 = new Thread(new Quay("Quầy 1"));
        Thread q2 = new Thread(new Quay("Quầy 2"));
        Thread q3 = new Thread(new Quay("Quầy 3"));

        q1.start();
        q2.start();
        q3.start();
    }
}