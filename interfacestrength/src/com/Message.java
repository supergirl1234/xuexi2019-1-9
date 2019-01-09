package com;

/**
 * Author:Fanleilei
 * Created:2018/12/16 0016
 */
public interface Message {
    //聊天功能
    void chat();

    //传输文件
    //void transportfile();

    //default的普通方法对象调用
    default void transportFile(){

        System.out.println("暂时不支持传输文件");
    }

    //static方法，接口类调用

    static void print(){

        System.out.println("这是聊天工具");
    }
}
