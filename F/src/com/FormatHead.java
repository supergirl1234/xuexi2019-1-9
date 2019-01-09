package com;

import java.io.*;

public class FormatHead {
    public static void code1(){

        try{
            Integer value=Integer.parseInt("abc");
            System.out.println(value);


        }catch(Exception e){

            System.out.println(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    public static void code2(){
        //OutputStream的输出位置变成屏幕（控制台）
        OutputStream out=System.out;
        try{
            out.write("Hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code3() {
        InputStream in=System.in;
        byte[] buff=new byte[5];
        System.out.println("请输入内容");
        try{
            int len=in.read(buff);
            System.out.println(new String(buff,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code4() {
        InputStream in=System.in;
        byte[] buff=new byte[5];
        System.out.println("请输入内容");
        int len=-1;
        try(ByteArrayOutputStream out=new ByteArrayOutputStream()){
            while(((len=in.read(buff))!=-1)){

                out.write(buff,0,len);
                if(len<buff.length){
                    break;

                }
            }
            System.out.println(new String(out.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        try(InputStream in=System.in;
            InputStreamReader inputStreamReader=new InputStreamReader(in);
            BufferedReader reader=new BufferedReader(inputStreamReader)
        ){
            String line;
            System.out.println("请输入内容：");
            while(!(line=reader.readLine()).equals("q")){
                System.out.println(line);


            }

            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
