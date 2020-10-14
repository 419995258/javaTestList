package testThread;

import java.util.concurrent.CountDownLatch;

public class test2 {

    public static void main(String[] args){
        //countDownLatch计数2个
        CountDownLatch countDownLatch = new CountDownLatch(2);
        // 线程1
        Runnable myRunnable1 = new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("线程1");
                    Thread.sleep(1000);
                    //countDownLatch计数-1
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 线程2
        Runnable myRunnable2 = new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("线程2");
                    Thread.sleep(5000);
                    //countDownLatch计数-1
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };



        Thread thread1 = new Thread(myRunnable1);
        thread1.start();

        Thread thread2 = new Thread(myRunnable2);
        thread2.start();


        //方法一：通过阻塞停止，最后执行f
/*
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        System.out.println("111");

        //方法二：通过countdownlatch计数执行
        try {
            //调用await方法阻塞当前线程，等待子线程完成后在继续执行
            System.out.println("111.222");
            countDownLatch.await();
            System.out.println("222");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("333");

    }





}
