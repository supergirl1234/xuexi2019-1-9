package com;

import java.util.concurrent.*;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class ThreadFive {

    public static void main(String[] args) {
        //业务
        Callable<String> callable=new MyCallable();
        FutureTask<String> futureTask=new FutureTask<String>(callable);
        Thread thread=new Thread(futureTask);
        thread.start();

        try {
            //String result=futureTask.get();//获得返回值
            String result=futureTask.get(1,TimeUnit.SECONDS);//如果1s还没有返回，我就终止了
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            //这句话去掉，就不会出现异常了
        }

        System.out.println("结束");
    }
}

class MyCallable implements Callable<String>{
     private int tick=10;

    @Override
    public String call() throws Exception {
        while (tick > 0) {
            //System.out.println( "剩余：" + tick-- + "张票");

            //如果要获得线程名Thread.currentThread().getName()
            //System.out.println( Thread.currentThread().getName()+"剩余：" + tick-- + "张票");
            tick++;
        }
        return "票卖完了";
    }
}
