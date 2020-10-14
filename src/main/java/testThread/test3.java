package testThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class test3 {

    public static void main(String[] args){

        ReentrantReadWriteLock l1 = new ReentrantReadWriteLock();
        Lock lock =l1.readLock();
        StampedLock l2 = new StampedLock();


        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(){
                public void run(){

                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "正在执行"+ finalI +"个乘客");
                        if(finalI % 2 == 0){
                            System.out.println("第"+ finalI +"个乘客可疑，需要再次查验");
                            Thread.sleep(5000);
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                        System.out.println(""+ finalI +"个乘客完成");
                    }
                }
            };
            thread.start();
        }

    }








}
