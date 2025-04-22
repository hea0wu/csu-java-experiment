package experiment4.question2;

import java.util.Random;

class DivisibleByThreeThread extends Thread {

    public DivisibleByThreeThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " 创建，开始执行...");

        Random rand = new Random();

        for (int num = 1; num <= 100; num++) {
            if (num % 3 == 0) {
                System.out.println("[3整除线程] " + Thread.currentThread().getName() + " 发现: " + num);
                try {
                    Thread.sleep(rand.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " 结束，退出。");
    }
}