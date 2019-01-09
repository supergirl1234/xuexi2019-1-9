package com;

public class FormatTwo {
    public static void main(String[] args) {
        System.out.println("");
        System.out.printf("%s","hello");
        System.out.println();
        System.out.printf("姓名：%s,年龄：%d,身高：%f","张三",12,188.7);
        System.out.println();
        System.out.printf("姓名：%s\n年龄：%d\n身高：%f\n","张三",12,188.7);
        System.out.println();
        System.out.printf("姓名：%s\n年龄：%10d\n身高：%f\n","张三",12,188.7);
        System.out.println();

        //String.format,System.out.printf用法一致
        //java.util.Formatter
        String rs=String.format("姓名：%s\n年龄：%10d\n身高：%f","张三",12,188.7);
        System.out.println(rs);
    }
}
