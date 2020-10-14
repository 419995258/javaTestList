package test;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import jdk.nashorn.internal.ir.LiteralNode;


public class test3 {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";


    public static void main(String[] args) throws InterruptedException {
       /* AtomicInteger atomicInteger = new AtomicInteger(0);


        ThreadLocal<String> s = new ThreadLocal<>();


        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 1/0;
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();;*/
        List<Integer> list = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        Long s = System.currentTimeMillis();
        for (Integer integer : list) {
            Thread.sleep(1);
        }
        Long e = System.currentTimeMillis();

        System.out.println(e-s);
        ExecutorService threadPool = new ThreadPoolExecutor(10,10,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2000000));

        Long s1 = System.currentTimeMillis();
        for (Integer integer : list) {
            threadPool.execute(()-> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            });
        }


        // 关闭线程池
        threadPool.shutdown();

        // 校验线程是否已经全部结束
        while (true){
            if(threadPool.isTerminated()){
                System.out.println("线程池已经结束运行");
                break;
            }
        }
        Long e1 = System.currentTimeMillis();
        System.out.println(e1-s1);


    }

    Thread thread = new Thread();


    private static test3 test3 = new test3();

    public static test3 getInstance(){
        return test3;
    }







}
