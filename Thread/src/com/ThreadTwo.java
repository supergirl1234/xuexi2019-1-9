package com;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class ThreadTwo {

    public  void print(Object... args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }

    }

    public static void main(String[] args) {

        //new ThreadTwo.print("hello","world");

        //使用多线程方法
        //1.复用业务逻辑
        //2.实现runnable接口，可以继续实现接口
        ThreadTwo task=new ThreadTwo();
       /* Runnable runnable=new PersonInfoRunnable(task);

        Thread thread1=new Thread(runnable);
        thread1.start();

        Thread thread2=new Thread(runnable);
        thread2.start();*/

       //使用Lambda表达式
       /* Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
               task.print("hello","hi");
            }
        };*/
       //换成Lambda表达式
        Thread thread=new Thread(() -> task.print("hello","hi"));
        System.out.println(thread.getName());
        thread.start();

        Thread thread1=new Thread(() -> task.print("hello","hi"));
        System.out.println(thread1.getName());
        thread1.start();

        Thread thread2=new Thread(() -> task.print("hello","hi"));
        thread2.setName("线程");
        System.out.println(thread2.getName());
        thread2.start();
    }
}



class PersonInfoRunnable implements  Runnable{

    private final ThreadTwo task;

    public PersonInfoRunnable(ThreadTwo task) {
        this.task = task;
    }

    @Override
    public void run() {

        this.task.print("hello","world");

    }
}


