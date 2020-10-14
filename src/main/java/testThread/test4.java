package testThread;

import testThread.productAndCousume.Test;

public class test4 {


    final static int LOOP = 1000;

    public static void main(String[] args) throws InterruptedException {

     Runnable runnable = new Runnable() {
         @Override
         public void run() {
             for(int i=0;i<10;i++){
                 System.out.println(i);
                 if(i == 5){
                     try {
                        System.out.println("休眠了");
                         Thread.sleep(2000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
     };

     Thread thread = new Thread(runnable);
     thread.start();





    }


}
