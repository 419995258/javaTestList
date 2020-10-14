package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import myUtil.DateFormater;

public class test2 {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";


    public static void main(String[] args) {
        LockA la = new LockA();
        new Thread(la).start();
        LockB lb = new LockB();
        new Thread(lb).start();
    }


    static class LockA implements Runnable{
        public void run() {
            try {
                System.out.println(new Date().toString() + " LockA 开始执行");
                while(true){
                    synchronized (obj1) {
                        System.out.println(new Date().toString() + " LockA 锁住 obj1");
                        Thread.sleep(3000); // 此处等待是给B能锁住机会
                        synchronized (obj2) {
                            System.out.println(new Date().toString() + " LockA 锁住 obj2");
                            Thread.sleep(60 * 1000); // 为测试，占用了就不放
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static class LockB implements Runnable{
        public void run() {
            try {
                System.out.println(new Date().toString() + " LockB 开始执行");
                while(true){
                    synchronized (obj2) {
                        System.out.println(new Date().toString() + " LockB 锁住 obj2");
                        Thread.sleep(3000); // 此处等待是给A能锁住机会
                        synchronized (obj1) {
                            System.out.println(new Date().toString() + " LockB 锁住 obj1");
                            Thread.sleep(60 * 1000); // 为测试，占用了就不放
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





}
