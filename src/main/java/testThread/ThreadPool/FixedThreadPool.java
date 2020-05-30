package testThread.ThreadPool;

/**
 * Created by PB on 2017/7/18.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定数量线程池（newFixedThreadPool）允许我们创建固定线程数量的线程池，
 * 如果任务数大于线程池中线程的数量，那么任务将等待.
 */
public class FixedThreadPool {
    public static  void  main(String[] args){
        try {
            // 创建三个线程
            ExecutorService threadPool = Executors.newFixedThreadPool(3);
            for(int i=1; i<=10; i++){
                threadPool.execute(new Runnable(){
                    public void run() {
                            // 线程中执行某些事物
                        try {
                            System.out.println(Thread.currentThread().getName() + "正在执行xxxx");
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            // 关闭线程池
            threadPool.shutdown();


            while (true){
                if(threadPool.isTerminated()){
                    System.out.println("线程池已经结束运行");
                    break;
                }
                Thread.sleep(200);
            }

            System.out.println("继续执行下面的东西");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
