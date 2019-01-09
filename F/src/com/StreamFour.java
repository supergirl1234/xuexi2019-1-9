package com;

import java.io.*;
import java.nio.file.Paths;

public class StreamFour {
    public static void code1() {
        //将小写转换为大写
        String data="Hello World";
        //字节内存流
        try(ByteArrayInputStream in=new ByteArrayInputStream(data.getBytes());
            ByteArrayOutputStream out=new ByteArrayOutputStream()
        ){

            byte[] buff=new byte[3];
            int len=-1;
            int count=0;
            while((len=in.read(buff))!=-1){

                //业务逻辑-》小写字母转为大写字母
                for(int i=0;i<len;i++){

                    byte b=buff[i];
                    if(b>='a'&& b<='z'){
                        count++;
                        buff[i]=(byte)(buff[i]-32);

                    }

                }
                out.write(buff,0,len);
            }
            byte[] newData=out.toByteArray();
            System.out.println(new String(newData));
            System.out.println("转换次数："+count);


        }catch(IOException e){


        }
    }


    //内存流合并2个文件
    public static void mergeFile(){


        //data-a.txt  data-b.txt  =>data.txt
        File file1=Paths.get("E:","test","data-a.txt").toFile();
        File file2=Paths.get("E:","test","data-b.txt").toFile();
        File file3=Paths.get("E:","test","data.txt").toFile();
        try(FileInputStream in1=new FileInputStream(file1);
             FileInputStream in2=new FileInputStream(file2);
             ByteArrayOutputStream memoryOut=new ByteArrayOutputStream();
             FileOutputStream out=new FileOutputStream(file3)
        ){
          //读文件，并写入内存流
            byte[] buff=new byte[3];
            int len=-1;
            while((len=in1.read(buff))!=-1){
                memoryOut.write(buff,0,len);

            }
            while((len=in2.read(buff))!=-1){
                memoryOut.write(buff,0,len);

            }
           //写入文件
            out.write(memoryOut.toByteArray());
        }catch(IOException e){


        }
    }

    //内存合并多个文件-文件不能太大，考虑内存有限
    public static void mergeFileBetter(String[] mergePaths,String outPath){
        //参数校验

        //初始化所有输入文件

        File[] files=new File[mergePaths.length];
        for(int i=0;i<mergePaths.length;i++){

            files[i]=new File(mergePaths[i]);
        }

        //输出流
        try(ByteArrayOutputStream memoryOut=new ByteArrayOutputStream();
            FileOutputStream out=new FileOutputStream(outPath)
        ){
            //遍历合并的文件，输入到内存流
            for(File f:files) {

                try (FileInputStream in = new FileInputStream(f)) {
                    byte[] buff = new byte[3];
                    int len = -1;
                    while ((len = in.read(buff)) != -1) {
                        memoryOut.write(buff, 0, len);
                    }
                }catch(IOException e){


                }
            }
            //内存流输出到文件
            out.write(memoryOut.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        mergeFile();
        mergeFileBetter(new String[]{
                "E:" + File.separator + "test" + File.separator + "data-a.txt",
                "E:" + File.separator + "test" + File.separator + "data-b.txt",
                "E:" + File.separator + "test" + File.separator + "data.txt"
        }, "E:" + File.separator + "test" + File.separator + "data2.txt");
    }



}
