package com;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class TestQueue {
    public static void code1(){
        Queue<String> queue=new LinkedList<>();
        System.out.println("队列元素是否为空："+queue.isEmpty());
        //入队列
        ((LinkedList<String>) queue).add("jaba");
        ((LinkedList<String>) queue).add("hello");
        ((LinkedList<String>) queue).add("hi");

        System.out.println("队列元素是否为空："+queue.isEmpty());
        System.out.println("队列元素个数："+queue.size());
        System.out.println("队列头元素为jaba:"+"jaba".equals(queue.peek()));
        System.out.println();
        //出队列
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());//null
        // 对列中如果没有元素了，再用poll()出队列，不会抛异常
    }

    public static void main(String[] args) {
       //生产者-消费者模型
       //生产者和消费者的能力不匹配（生产的速度和消费的速度不匹配）
       //采用队列的方式存储生产消费的资源（元素），解耦生产者和消费者的实现逻辑
        Queue<String> queue=new LinkedList<>();
        //生产者
        new Thread(new Runnable() {

            {

                System.out.println("生产者线程启动");
            }
            @Override
            public void run() {
              while(true){

                  try {
                      Thread.sleep(2000);//1秒
                      //生产数据
                      String data=String.valueOf(Math.random());
                      System.out.println("生产："+data);
                      queue.add(data);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

              }
            }
        }).start();

        //消费者
        new Thread(new Runnable() {
            {

                System.out.println("消费者线程");
            }
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("消费："+queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        //只要不输出东西，就一直等待
        try {
            int in=System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
