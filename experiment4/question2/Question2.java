package experiment4.question2;

public class Question2 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("MyThread");
        Thread t2 = new PrimeThread("PrimeThread");
        Thread t3 = new DivisibleByThreeThread("DivisibleByThreeThread");

        t1.start();
        t2.start();
        t3.start();
    }
}
