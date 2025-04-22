package experiment4.question2;

import java.util.Random;

class PrimeThread extends Thread {
    public PrimeThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " 创建，开始执行...");

        Random rand = new Random();

        for (int num = 2; num <= 100; num++) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("[素数线程] " + Thread.currentThread().getName() + " 发现素数: " + num);
                try {
                    Thread.sleep(rand.nextInt(120));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " 结束，退出。");
    }
}