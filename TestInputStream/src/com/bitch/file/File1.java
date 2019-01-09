package com.bitch.file;

import java.io.File;
import java.io.IOException;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class File1 {


    public static void code1() {
        File file=new File("E:\\hello.txt");

        try {
            if(file.createNewFile()){
                System.out.println("创建文件成功");
            }else{

                System.out.println("创建文件失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {

        //1.不同系统下文件路径分隔符不同：windows->\   ,Linux->/  ,unix->/
        //此时代码跨平台 注意使用File.separator
        //2.路径分隔符：windows->;   ,Linux->:  ,unix->:
        //此时代码跨平台注意使用File.pathSeparator
        //3.文件名大小写：windows->不区分 ，Linux  unix->区分
        //关于文件名在windows下避免大小写，注意区分

        File file=new File("E:\\hello.txt");
        // File file=new File("E:"+File.separator+"hello.txt");
        //判断文件是否存在
        if(file.exists()){

            if(file.delete()) {
                System.out.println("文件存在，删除成功");
            }else{

                System.out.println("文件存在，删除不成功");
            }
        }else{

            try {
                if(file.createNewFile()){
                    System.out.println("文件不存在，创建成功");

                }else{

                    System.out.println("文件不存在，创建不成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
