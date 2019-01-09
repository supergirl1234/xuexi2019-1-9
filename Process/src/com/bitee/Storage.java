package com.bitee;


import java.util.LinkedList;

import java.util.Scanner;


/**
 * Author:Fanleilei
 * Created:2018/12/26 0026
 */
public class Storage {

    protected static LinkedList<LittleStor> block;

    public Storage( ) {

        this.block = new LinkedList<>();
        block.add(new LittleStor(0, 20, true));
        block.add(new LittleStor(20, 30, true));
        block.add(new LittleStor(50, 70, true));
        block.add(new LittleStor(120, 100, true));
        block.add(new LittleStor(220, 420, true));
    }

    //打印出内存表
    public static void print() {
        System.out.println("起始地址"+"\t"+"空间大小"+"\t"+"状态（true代表空闲，false代表已分配）");
        for(int i = 0; i<block.size(); i++) {
            System.out.println(block.get(i).getStartAddress()+"\t\t"+
                    block.get(i).getSize()+"\t\t"+
                    block.get(i).isStatus());
        }
    }
    //按地址递增的顺序排列
    public static void Sort(){


        for (int i=0;i<block.size()-1;i++){
            int k=block.get(i).getStartAddress();
            for (int j=i+1;j<block.size();j++){
                if(block.get(j).getStartAddress()<k){

                    LittleStor sw=block.get(j);
                    block.set(j,block.get(i));
                    block.set(i,sw);

                }

            }

        }
    }

    //按空间大小递增的顺序排列
    public static void SortSize(){


        for (int i=0;i<block.size()-1;i++){
            int k=block.get(i).getSize();
            for (int j=i+1;j<block.size();j++){
                if(block.get(j).getSize()<k){

                    LittleStor sw=block.get(j);
                    block.set(j,block.get(i));
                    block.set(i,sw);

                }

            }

        }
    }


    //首次适应算法
    public  static void FF() {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("请输入要分配的内存的大小");
            int size = scanner.nextInt();
            if(size==0){
                break;
            }

            for (int i = 0; i < block.size(); i++) {
                if (block.get(i).getSize() >= size && block.get(i).isStatus() == true) {
                    int temp;
                    int addre;
                    temp = block.get(i).getSize() - size;
                    addre = block.get(i).getStartAddress() + size;
                    block.get(i).setSize(size);
                    block.get(i).setStatus(false);

                    if (temp > 0) {
                        block.add(new LittleStor(addre, temp, true));

                    }
                    break;
                }

            }

            //System.out.println("没有合适的内存分配");


            Sort();
             print();
        }
    }

    //循环首次适应算法
    public static void NF(){


    }

    //最佳适应算法
    public static void BF(){

        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("请输入要分配的内存的大小");
            int size = scanner.nextInt();
            if (size == 0) {
                break;
            }
            //先将分区按大小进行排序
            SortSize();
            for(int i=0;i<block.size();i++){

                if (block.get(i).getSize() >=size &&block.get(i).isStatus() == true){

                    int temp;
                    int addre;
                    temp = block.get(i).getSize() - size;
                    addre =block.get(i).getStartAddress() + size;
                    block.get(i).setSize(size);
                    block.get(i).setStatus(false);

                    if (temp > 0) {
                        block.add(new LittleStor(addre, temp, true));

                    }
                    break;
                }
            }
            //System.out.println("没有合适的内存分配");

            Sort();
            print();
        }

    }

    //最坏适应算法
    public static void WF(){
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("请输入要分配的内存的大小");
            int size = scanner.nextInt();
            if (size == 0) {
                break;
            }
            //先找出最大的内存
            LittleStor max = block.get(0);
            for (int i = 1; i < block.size(); i++) {

                if (block.get(i).getSize() >=max.getSize()&& block.get(i).isStatus() == true) {
                    max = block.get(i);
                }

            }

            if (max.getSize() >=size) {
                int temp;
                int addre;
                temp = max.getSize() - size;
                addre = max.getStartAddress() + size;
                max.setSize(size);
                max.setStatus(false);

                if (temp > 0) {
                    block.add(new LittleStor(addre, temp, true));

                }


            }
            Sort();
            print();


        }
    }


    public static void main(String[] args) {
        Storage storage=new Storage();
        print();

        System.out.println("请输入要选择的内存分配算法：1.FF；2.BF,3.WF,4.NF");

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n) {

            case 1:
                FF();
                break;
            case 2:
                BF();
                break;
            case 3:
                WF();
                break;
            case 4:
                NF();
                break;
            default:
                System.out.println("请重新选择");
        }


    }

}

class LittleStor{
    private int startAddress;
    private int size;
    private  boolean status;

    public LittleStor(int startAddress, int size, boolean status) {
        this.startAddress = startAddress;
        this.size = size;
        this.status = status;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}


