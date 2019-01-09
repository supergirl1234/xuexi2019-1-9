package com;

import java.io.*;
import java.nio.file.Paths;

public class StreamFive {
    public static void write() {
        File file=Paths.get("E:","test","test.txt").toFile();
        try(Writer writer=new FileWriter(file)){
             writer.write("Hello 你好！");
             writer.write("hjjxnnxd");
             writer.write(new char[]{'A','B','C','\n'});//为什么换行没起作用
             writer.write(new char[]{'a','b','c','d'},2,1);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public  static  void reader(){

       File file=Paths.get("E:","test","test.txt").toFile();
       try(Reader reader=new FileReader(file)){
           char[] buffer=new  char[3];
           int len=-1;
           while((len=reader.read(buffer))!=-1){
               System.out.println(new String (buffer,0,len));

           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    public static void code1() {
        File file=Paths.get("E:","test","test.txt").toFile();
        try(Writer writer=new FileWriter(file)){
            writer.write("Hello 你好！");
            writer.write("hjjxnnxd");
            writer.flush();//缓冲区的内容输出到目的地
            writer.write(new char[]{'A','B','C','\n'});//为什么换行没起作用
            writer.write(new char[]{'a','b','c','d'},2,1);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        //write();
        //reader();
        File file=Paths.get("E:","test","test.txt").toFile();
        //通过字节流构造字符流对象，注意编码格式
        try(FileOutputStream out = new FileOutputStream(file);
            //字符流
            OutputStreamWriter writer = new OutputStreamWriter(out)
        ){
          writer.write("hello 我们做朋友吧");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
