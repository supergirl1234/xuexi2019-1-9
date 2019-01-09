package com;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
//1.通过继承Thread实现多线程
//2.run方法不会启动线程，他就是一个普通的方法调用
//3.Thread的start方法启动线程
public class ThreadFirst extends Thread {

    private final String title;

    public ThreadFirst(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        //多线程处理的业务逻辑
        for (int i=0;i<10;i++){

            System.out.println(this.title+" "+i);
        }
    }

    public static void main(String[] args) {

        //run方法不会启动线程，他就是一个普通的方法调用
        //Thread的start方法启动线程
        ThreadFirst thread1=new ThreadFirst("线程1");
        //thread1.run();
        thread1.start();
        ThreadFirst thread2=new ThreadFirst("线程2");
        //thread2.run();
        thread2.start();

    }
}
