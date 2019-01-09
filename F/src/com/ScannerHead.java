package com;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScannerHead {
    public static void code1(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入内容：");
        if(scanner.hasNext()){//有输入内容,不判断空字符串

            System.out.println(scanner.next());
        }
        scanner.close();
    }

    public static void code2() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年龄：");
        while(true){
            if(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
                break;
            }else{

                System.out.println("输入的不是数字，重新输入");
                scanner.next();//丢弃掉不符合要求的数据
            }

        }
        scanner.close();
    }

    public static void code3() {
        //Scanner构造方法中传入文件，替代BufferedReader，读取文件
        try(Scanner scanner=new Scanner(Paths.get("E:","test","test.txt"));){

            scanner.useDelimiter("\n") ;
            while(scanner.hasNext()){

                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生日：");
        while (true) {
            // 2018-05-07
            if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println(scanner.next());
                break;
            } else {
                System.out.println("输入的日期格式不正确,重新输入");
                scanner.next();//丢弃掉不符合要求的数据
            }
        }
        scanner.close();
    }

}
