package com;

import java.io.*;
import java.nio.file.Paths;

public class StreamThree {

    public static void code1() {
        File file=Paths.get("E:","test","test.txt").toFile();
        File destfile=Paths.get("E:","test","test2.txt").toFile();
        //字节输入流和输出流的缓存方式读取和写入
        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out= new FileOutputStream(destfile)){

            byte[] buff=new byte[3];//每次可以读取的最大数量
            int len=-1;
            while((len=in.read(buff))!=-1){

                out.write(buff,0,len);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


       //文件复制
       public static void copy(String srcFilePath,String destFilePath){
        //参数校验
           if(srcFilePath==null || srcFilePath.isEmpty()){
               throw new IllegalArgumentException("srcFilePath must be not null/Empty");

           }
           if(destFilePath==null|| destFilePath.isEmpty()){
               throw new IllegalArgumentException("destFilePath must be not null/Empty");


           }
           //文件校验以及准备工作
           File srcFile=Paths.get(srcFilePath).toFile();
           File destFile=Paths.get(destFilePath).toFile();

           if(!srcFile.exists()|| !srcFile.isFile()){

               throw new IllegalArgumentException("srcFilePath file not exist or not file");
           }

           File  parentFile=destFile.getParentFile();

           if(!parentFile.exists()){
               if(!parentFile.mkdirs()){

                   throw new IllegalArgumentException("can't create " + parentFile.getAbsolutePath() + " directory");
               }

           }

           //文件复制
           try (FileInputStream in = new FileInputStream(srcFile);
                FileOutputStream out= new FileOutputStream(destFile)){

               byte[] buff=new byte[1024];//每次可以读取的最大数量
               int len=-1;
               while((len=in.read(buff))!=-1){

                   out.write(buff,0,len);
               }
           } catch (FileNotFoundException e1) {
               e1.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }


       }

    public static void main(String[] args) {

        String src="E:\\test\\test.txt";
        String dest="E:\\test\\test2.txt";
        copy(src,dest);
    }



}
