package com.bitee;



import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2018/12/29 0029
 */
public class Yinhang {

    //检测安全性，若安全并给出安全序列
    //s->Allocation n->Need  w->work  F->Finish
    public static void Check(int[][] s,int[][] n,int[] w,Boolean[] F) {
        //一个存放安全序列的数组
        String[] Cunfang=new String[s.length];
        int k=0;
        for( k=0;k<s.length;k++){  //外循环
            int i = 0;
            for (i = 0; i < s.length; i++) {
                if (F[i] == false) {
                    int j = 0;
                    for (j = 0; j < w.length; j++) {
                        if (n[i][j] > w[j]) {
                            break;
                        }
                    }
                    if (j < w.length) {
                        continue;
                    } else {

                            for (j = 0; j < w.length; j++) {
                                w[j] = w[j] + s[i][j];
                            }
                            F[i] = true;
                            //System.out.print("P" + i + "  ");
                            String str="P";
                            Cunfang[k]=str+i;
                    }
                    break;
                }
            }
            if (i==s.length){
                System.out.print("不存在安全序列");
                break;
            }

        }
        if (k==s.length){

            for(int i=0;i<s.length;i++){
                System.out.print(Cunfang[i]+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入资源种数");
        int n=scanner.nextInt();
        int[] Available=new int[n];

        System.out.println("请输入每个资源的数量");
        for(int i=0;i<n;i++){
            int num=scanner.nextInt();
            Available[i]=num;

        }
        System.out.println("每个资源的数量为：");
        for (int i=0;i<n;i++){

            System.out.print(Available[i]+" ");
        }
        System.out.println();

        System.out.println("请输入进程个数");
        int a=scanner.nextInt();
        int[][] Max=new int[a][n];
        int[][] Allocation=new int[a][n];
        int[][] Need=new int[a][n];
        for(int i=0;i<a;i++){
            System.out.println("请输入第"+(i+1)+"个进程的最大需求量");
               for(int j=0;j<n;j++) {

                   int b = scanner.nextInt();
                   Max[i][j]=b;

               }
        }

        System.out.println("每个进程的最大资源需求量：");

        for(int i=0;i<a;i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(Max[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println("请为每个进程分配资源数");
        for(int i=0;i<a;i++){
            System.out.println("请输入第"+(i+1)+"个进程的已分配资源数");
            for(int j=0;j<n;j++) {

                int c = scanner.nextInt();
                Allocation[i][j]=c;

            }
        }
        System.out.println("每个进程已分配的资源数：");
        for(int i=0;i<a;i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(Allocation[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println("每个进程还需要的资源数：");
        for(int i=0;i<a;i++) {

            for (int j = 0; j < n; j++) {
                Need[i][j]=Max[i][j]-Allocation[i][j];
                System.out.print(Need[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println("还剩余的资源数量");
        for(int i=0;i<n;i++){
            for(int j=0;j<a;j++){

                Available[i]=Available[i]-Allocation[j][i];
            }

            System.out.print(Available[i]+" ");
        }
        System.out.println();
       //工作向量work，初始值等于Available
        int[] work = new int[n];
        for (int i = 0; i < n; i++) {
            work[i] = Available[i];

        }
        //Finish
        Boolean[] Finish = new Boolean[a];
        for (int i = 0; i < a; i++) {

            Finish[i] = false;
        }

        //进行安全性检测
        System.out.println("安全序列为：");

        Check(Allocation, Need,work,Finish);


     //Request
     while(true){
         System.out.println();
        System.out.println("请输入请求资源的进程号：（0、1...）");
        int num=scanner.nextInt();
        System.out.println("请输入请求的资源数");
        int Request[]=new int[n];

        for (int i=0;i<n;i++){
            int r=scanner.nextInt();
            Request[i]=r;
        }

            int i=0;
            for(i=0;i<n;i++){
                //比较Request和Need
                if(Request[i]>Need[num][i]){
                    System.out.println("因为请求的资源量大于需求量，所以系统不分配资源");
                    break;
                }

                //比较Request和Available
                if(Request[i]>Available[i]){
                    System.out.println("因为请求的资源量大于可用资源量，所以系统不分配资源");
                    break;
                }

            }
            //如果Request<=Need  Request<=Available,就尝试着分配一下资源
         if(i==n){
             for(int j=0;j<n;j++) {
                 Available[j] = Available[j] - Request[j];
                 work[j] = Available[j];
                 Allocation[num][j] = Allocation[num][j] + Request[j];
                 Need[num][j] = Need[num][j] - Request[j];
             }
             for ( int j = 0; j < Allocation.length; j++) {

                 Finish[j] = false;
             }
             System.out.println("安全序列为：");

             Check(Allocation, Need,work,Finish);
            //如果不是安全序列，则回收资源
             for( i=0;i<Allocation.length;i++){
                 if(!Finish[i]==true){

                     for(int j=0;j<n;j++) {
                         Available[j] = Available[j] +Request[j];
                         work[j] = Available[j];
                         Allocation[num][j] = Allocation[num][j] - Request[j];
                         Need[num][j] = Need[num][j] +Request[j];
                     }
                     break;
                 }

             }

             //如果Need=0；则回收它的所有资源

                   int j = 0;
                   for (j = 0; j < n; j++) {
                       if (Need[num][j] == 0) {

                           continue;
                       }
                       break;

                   }
                   if (j == n) {
                       for (i = 0; i < n; i++) {
                           Available[i] = Available[i] + Max[num][i];

                       }

                   }



             System.out.println();
             System.out.println("可用资源还有：");
             for( i=0;i<n;i++){
                 System.out.print(Available[i]+" ");
             }
         }


     }

    }

}
