package com.bit;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Filqe {



    public static void print(File f){

        if(f.exists()&& f.isFile()){
            System.out.print("F");
            System.out.print(f);
            System.out.print(" 文件大小：" + f.length());
            System.out.println(" 最后一次修改日期: " + new Date(f.lastModified()));
        }else{
            File[] files=f.listFiles();
            for (File c : files) {

                System.out.print(c);
                System.out.print(" 文件大小：" + c.length());
                System.out.println(" 最后一次修改日期: " + new Date(c.lastModified()));
            }
        }

    }

    public static void tree(File f){

        if(f.exists()&&f.isDirectory()){
            System.out.println(f.getName());
            File[] file=f.listFiles();
            if(file!=null) {
                for (File c : file) {

                    tree(c);
                }
            }

        }else{

            System.out.println("|"+f.getName());
        }


    }
    public static void main(String[] args){

        File file = new File("D"+File.separator + "javaCode" ) ;

    }
}



