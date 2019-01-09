package com.bitee;

import java.util.Scanner;

public class Process {



    private  double finishtime;
    public String name;
    public double arrivetime;
    public double servicetime;
    private double starttime;

    public double zhouzhuantime;
    public double rate;
    public Process(String name, int arrivetime, int servicetime, int starttime, int finishtime){

    }
    public Process(String name,double arrivetime,double servicetime,double starttime,double finishtime,double zhouzhuantime){
        this.name=name;
        this.arrivetime=arrivetime;
        this.servicetime=servicetime;
        this.setStarttime(starttime);
        this.finishtime=finishtime;
        this.zhouzhuantime=zhouzhuantime;

    }

    public double getStarttime() {
        return starttime;
    }

    public void setStarttime(double starttime) {
        this.starttime = starttime;
    }
    public void setRate(double rate){this.rate=rate;}

    //周转时间
    public static void Zhouzhuan(Process[] p){
        for(int i=0;i<p.length;i++) p[i].zhouzhuantime = p[i]. finishtime - p[i].arrivetime;
    }
    //按到达时间排序
    public static void Sort(Process[] p){
        Process temp;
        int i=0;
        int k = 0;
        for( i=0;i<p.length;i++)
            k=i;

        for (int j = i+1; j < p.length ; j++) {
                if (p[k].arrivetime > p[j ].arrivetime) {
                    temp = p[j];
                    p[k] = p[j];
                    p[j] = temp;
                }
            }

    }
    //先来先服务
    public static void Fcfs(Process[] p){
        //先排序
        Sort(p);
        p[0].setStarttime(p[0].arrivetime);
        p[0].finishtime= p[0].getStarttime() +p[0].servicetime;
        for(int i=1;i<p.length;i++)
            if (p[i].arrivetime < p[i - 1].finishtime) {
                p[i].setStarttime(p[i - 1].finishtime);
                p[i].finishtime = p[i].getStarttime() + p[i].servicetime;
            } else {

                p[i].setStarttime(p[i].arrivetime);
                p[i].finishtime = p[i].arrivetime + p[i].servicetime;
            }
        Zhouzhuan(p);
        for(int i=0;i<p.length;i++)
            System.out.println("进程名" + p[i].name + "到达时间" + p[i].arrivetime + "服务时间" +
                    p[i].servicetime + "开始时间" + p[i].getStarttime() + "完成时间" + p[i].finishtime
                    +"周转时间"+p[i].zhouzhuantime );
    }
    //短作业优先
    public static void Sjf(Process[] p){
        //先找出来最先到达的进程，先执行最先到达的进程
        Sort(p);
        p[0].setStarttime(p[0].arrivetime);
        p[0].finishtime= p[0].getStarttime() +p[0].servicetime;

        //服务时间按从小到大排序,除去第一个到达的
        Process temp;
        for(int i=1;i<p.length-1;i++)
            for (int j = 1; j < p.length - i; j++)
                if (p[j].servicetime > p[j + 1].servicetime) {

                    temp = p[j + 1];
                    p[j + 1] = p[j];
                    p[j] = temp;
                }
        //调度
        for(int i=1;i<p.length;i++){

            p[i].setStarttime(p[i-1].finishtime);
            p[i].finishtime= p[i].getStarttime() +p[i].servicetime;
        }
        Zhouzhuan(p);
        for(int i=0;i<p.length;i++)
            System.out.println("进程名" + p[i].name + "到达时间" + p[i].arrivetime + "服务时间" +
                    p[i].servicetime + "开始时间" + p[i].getStarttime() + "完成时间" + p[i].finishtime
                    +"周转时间"+p[i].zhouzhuantime);


    }

    //优先级调度算法

    //根据优先级将进程排序
    public static void Sort2(Process[] p){
        Process temp;
        int i = 0;
        int k = 0;
        for (i = 0; i < p.length; i++)
            k = i;

        for (int j = i + 1; j < p.length; j++) {
            if (p[k].rate < p[j].rate) {
                temp = p[j];
                p[k] = p[j];
                p[j] = temp;
            }
        }
    }
    public static void Psa(Process[] p){

        System.out.println("请输入每一个进程的优先级：");
        Scanner pu = new Scanner(System.in);

            int a = pu.nextInt();
            for (int i = 0; i < p.length; i++) {

                p[i].rate = a;
            }

        //先根据优先级进行排序
        Sort2(p);
        //调度
        p[0].setStarttime(p[0].arrivetime);
        p[0].finishtime= p[0].getStarttime() +p[0].servicetime;
        for (int i=1;i<p.length;i++){

            p[i].setStarttime(p[i-1].finishtime);
            p[i].finishtime= p[i].getStarttime() +p[i].servicetime;

        }
        Zhouzhuan(p);
        for( int i=0;i<p.length;i++){

            System.out.println("进程名" + p[i].name + "到达时间" + p[i].arrivetime + "服务时间" +
                    p[i].servicetime + "开始时间" + p[i].getStarttime() + "完成时间" + p[i].finishtime
                    +"周转时间"+p[i].zhouzhuantime);
        }
    }


    //高响应比优先调度算法
     //计算每一个进程的高响应比
    public static void Cal(Process[] p){

        for(int i=1;i<p.length;i++)
            p[i].rate = 1 + (p[0].finishtime - p[i].arrivetime) / p[i].servicetime;
    }
    //根据高响应比，找出优先级最高的
    public static void Compete(Process[] p){
        Cal(p);
       Process temp;
       for(int i=1;i<p.length;i++){
             for(int j=i+1;j<p.length;j++){

                 if(p[j].rate>p[i].rate){
                     temp=p[j];
                     p[j]=p[i];
                     p[i]=temp;

                 }
             }

       }

    }

    //高响应比调度算法
    public static void Hrrn(Process[] p){
        //先执行第一个到达的进程
        p[0].setStarttime(p[0].arrivetime);
        p[0].finishtime= p[0].getStarttime() +p[0].servicetime;
        //每完成一个调度就算一次高响应比

        //高响应比由大到小排序

        //调度
        for(int i=1;i<p.length;i++){
            Compete(p);
            p[i].setStarttime(p[i - 1].finishtime);
            p[i].finishtime = p[i].getStarttime() + p[i].servicetime;


        }

        Zhouzhuan(p);
         for(int i=0;i<p.length;i++)
            System.out.println("进程名" + p[i].name + "到达时间" + p[i].arrivetime + "服务时间" +
                    p[i].servicetime + "开始时间" + p[i].getStarttime() + "完成时间" + p[i].finishtime
                    +"周转时间"+p[i].zhouzhuantime);

    }


    public static void main(String[] args){


       Process[] process=new Process[]{new Process("A", 1, 2, 0, 0, 0),
               new Process("B", 1.3, 6, 0, 0, 0),
               new Process("C",2,2,0,0,0),new Process("D",
               2,1,0,0,0)};
               //System.out.println("请输入进程个数：");
        Scanner in = new Scanner(System.in);
        /*int n=in.nextInt();
        Process[] process=new Process[n];//duixiangshuzu
        System.out.println("请输入进程名、到达时间、服务时间");
        for(int i=0;i<n;i++){
            String name=in.nextLine();
            int arrivetime=in.nextInt();
            int servicetime=in.nextInt();
            int starttime=0;
            int finishtime=0;
            process[i]=new Process(name,arrivetime,servicetime,starttime,finishtime);

        }*/

        System.out.println("请选择进程调度算法：1:FCFS，2:SJF，3:HRRN");
        int type = in.nextInt();
        switch (type) {

            case 1:
                Fcfs(process);
                break;
            case 2:
                Sjf(process);
                break;
            case 3:
                Hrrn(process);
                break;


            default:
                break;

        }


    }



}
