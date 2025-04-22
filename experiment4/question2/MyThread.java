package experiment4.question2;

import java.util.Random;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " 创建，开始执行...");

        try {
            int sleepTime = new Random().nextInt(1000);
            Thread.sleep(sleepTime); // 线程休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 结束，退出。");
    }
}