package com;

/**
 * Author:Fanleilei
 * Created:2018/12/16 0016
 */
public class QQMessage implements Message{
    @Override
    public void chat() {
        System.out.println("QQ聊天");
    }

    public void transportFile(){

        System.out.println("QQ传输文件");
    }
}
