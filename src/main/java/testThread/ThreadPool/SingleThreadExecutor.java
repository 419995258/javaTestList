package testThread.ThreadPool;

/**
 * Created by PB on 2017/7/18.
 */

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 实现线程挂掉后重新启动（创建单一的线程池）newSingleThreadExecutor()，这样线程池中只会有一个线程工作，当
 * 线程失败后会重新创建一个线程将失败的线程替换掉定时器线程池（scheduleAtFixedRate）与定时器很类似，可以指定
 * 线程池中线程在多长时间后执行，以及每个多长时间执行一次，
 * 代码如下，可以模拟让炸弹在6s后爆炸，并且每隔2s炸一次：
 */
public class SingleThreadExecutor {
    public static void main(String[] args){
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
//      .schedule(
                new Runnable(){

                    public void run() {
                        System.out.println("boming");
                    }

                }, 6, 2, TimeUnit.SECONDS);
    }
}

