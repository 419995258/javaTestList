package testThread;

import java.lang.reflect.Proxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test5 {
    public static  Integer iii = 0;
    public static void main(String[] args){

        CountDownLatch countDownLatch = new CountDownLatch(6);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,5,60,TimeUnit.SECONDS,new LinkedBlockingDeque<>(2));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                        iii = iii + 1;
                        System.out.println(iii);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        };

        Thread thread = new Thread();

        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);


        System.out.println("当前活动线程数："+ poolExecutor.getActiveCount());
        System.out.println("核心线程数："+ poolExecutor.getCorePoolSize());
        System.out.println("总线程数："+ poolExecutor.getPoolSize());
        System.out.println("最大线程池数量"+poolExecutor.getMaximumPoolSize());
        System.out.println("线程处理队列长度"+poolExecutor.getQueue().size());


        try {
            //调用await方法阻塞当前线程，等待子线程完成后在继续执行
            countDownLatch.await();
            System.out.println("数据同步完成1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据同步完成2");
        System.out.println(iii);


    }
}
