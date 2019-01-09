package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class FileTwo {
    public static void code1() {
        File file=new File("E:"+File.separator+"test"+File.separator+"a"+File.separator+"test.txt");
        if (!file.exists()){

            File parentFile=file.getParentFile();
            //if (!parentFile.exists()){
            //mkdir只会创建当前目录
            // if(parentFile.mkdir()){

            //  System.out.println("创建目录成功");
            //}
            // }
            if (!parentFile.exists()){
                //mkdirs会创建目录及上级目录，但不会创建文件
                if (parentFile.mkdirs()){

                    System.out.println("创建目录成功");
                }
            }
            try {
                if (file.createNewFile()){

                    System.out.println("文件创建成功");
                }else{
                    System.out.println("文件创建失败");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void code2() {
        File file=new File("E:"+File.separator+"test");
        System.out.println("文件是否为目录："+file.isDirectory());
        System.out.println("文件是否为普通文件："+file.isFile());
        System.out.println("文件大小："+file.length());
        System.out.println("文件最后修改时间："+new Date(file.lastModified( )));

    }

    public static void code3() {
        File file=new File("E:"+File.separator+"test");
        if (file.exists()&&file.isDirectory()) {
            //file是普通文件返回null，如果是目录则返回目录下的所有文件及文件夹
            File[] result = file.listFiles();
            if (result != null) {
                for (File c : result) {

                    //System.out.println(c);
                    System.out.println(c.getName());
                    System.out.println(c.getAbsolutePath());
                }

            }
        }
    }

    public static void code4() {

        Path path= Paths.get("E:","test");
        Path path1= Paths.get("E:","test","file_info.txt");

        File file=path.toFile();
        File file1=Paths.get("E:","test").toFile();

        try{

            Files.delete(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //通过递归方式遍历指定文件目录下的所有文件以及子目录
    public static void findFile(File file){

        if (file.isFile()){

            System.out.println(file.getName());
        }else{
            System.out.println(file.getName());
            File[] files=file.listFiles();
            if(files!=null){
                for(File f:files){
                    findFile(f);

                }

            }
        }
    }
//通过递归方式遍历指定文件目录下的所有文件以及子目录,且能显示出层级
    public static void findFile2(File file,int level){

        if (file.isFile()){

            System.out.println(repeatSpace(level)+"|-"+file.getName());
        }else{
            System.out.println(repeatSpace(level)+"+"+file.getName());
            File[] files=file.listFiles();
            if(files!=null){
                for(File f:files){
                    findFile2(f,level+2);

                }

            }
        }
    }

    private static String repeatSpace(int count){

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=count;i++){
            sb.append(" ");

        }
        return sb.toString();

    }
       public static void main(String[] args) {
           File file=new File("E:"+File.separator+"a");
           findFile(file);
           System.out.println();
           findFile2(file,2);
    }
}
