package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import myUtil.DateFormater;

public class test {
    public static void main(String[] args) throws IOException {
        String a ="1";
        String b ="1";
        String c ="1"+"";
        String d =a+"1";
        String e ="1";
        String f ="1";

        System.out.println(c == d);

        AtomicInteger atomicInteger = new AtomicInteger();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        Integer aa = 1;
        Integer bb = 1;
        System.out.println(aa == bb);

        HashMap<String,Object> hashMap = new HashMap<>();

        BlockingQueue mq = new LinkedBlockingDeque(5);




        String lastMonth = DateFormater.DateToString(DateFormater.getAfterMonth(new Date(), -1), "yyyy_MM");
        lastMonth=lastMonth.substring(2, lastMonth.length());
        System.out.println(lastMonth);

        Double dd = 2.1;
        System.out.println(dd - dd.intValue() == 0);

        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        try {
            b();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("异常了");
        }
        System.out.println("over");


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(-1);
        list.add(2);
        list.add(2);
        list.add(8);
        list.add(8);
        List<Integer> newList = list.stream().sorted().collect(Collectors.toList());;
        System.out.println(newList);


        System.out.println("pb".hashCode());


        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(2);
        list2.add(1);
        list2.add(5);

        list.addAll(list2);

        System.out.println("1");

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 /1024);
        System.out.println(Runtime.getRuntime().totalMemory()/ 1024 /1024);


        Map<String,Object> m = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            new Thread(() -> {
                m.put(finalI + "", finalI);
                System.out.println(m.toString());
            }).start();
        }

    }


    public static void b() throws Exception{
            String a[] = {"0"};
            System.out.println(a[1]);
    }





}
