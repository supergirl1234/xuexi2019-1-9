package com;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.Date;

public class FileThree {

    //1.传入一个文件F
    //2.打印输出如下内容
    //2.1.每一个文件一行
    //2.2 F\D name size last_modified

    public static void print(File f){
        if(f==null){
            return ;

        }
        System.out.println(f.isFile()?"F":"D"+"   "+f.getName()+" "+f.length()+" "+new Date(f.lastModified()));
        File[] files=f.listFiles();
        if (files!=null){

            for (File c:files){

                System.out.println(c.isFile()?"F":"D"+"   "+c.getName()+" "+c.length()+" "+new Date(c.lastModified()));
            }
        }

    }

    public static void main(String[] args) {
        File file=new File("E:"+File.separator+"a");
        print(file);
    }
}
