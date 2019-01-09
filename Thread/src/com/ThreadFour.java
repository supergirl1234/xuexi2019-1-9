package com;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class ThreadFour extends Thread {


    public static void main(String[] args) {

         Runnable runnable=new Runnable() {
             private int tick=10;
             @Override
             public void run() {
                 while (tick > 0) {
                     //System.out.println( "剩余：" + tick-- + "张票");
                     //如果要获得线程名Thread.currentThread().getName()
                     System.out.println( Thread.currentThread().getName()+"剩余：" + tick-- + "张票");
                 }
             }
         };

         Thread thread1=new Thread(runnable,"Thread-A");
         Thread thread2=new Thread(runnable,"Thread-B");
         thread1.start();
         thread2.start();




    }
}
