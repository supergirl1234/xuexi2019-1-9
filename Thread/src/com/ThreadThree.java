package com;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class ThreadThree extends Thread {

    //private  int tick=10;
    //如果tick不是静态的，Thread-A和Thread-B两个线程就变成自己卖各自的票，他们两个没有关联
    //将其改为静态的，tick就变成共享的
    private  static int tick=10;

    @Override
    public void run() {
        while (tick > 0) {
            System.out.println(this.getName() + "剩余：" + tick-- + "张票");
        }
    }
    public static void main(String[] args) {

            Thread thread1=new ThreadThree();
            thread1.setName("Thread-A");
            Thread thread2=new ThreadThree();
            thread2.setName("Thread-B");
            thread1.start();
            thread2.start();


    }
}
