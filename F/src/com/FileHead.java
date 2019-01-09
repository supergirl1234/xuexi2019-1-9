package com;

import java.io.File;
import java.io.IOException;

public class FileHead {
    public static void code1() {
        File file=new File("E:\\hello.txt");
        try {
            if(file.createNewFile()){
                System.out.println("创建文件成功");

            }else {

                System.out.println("创建文件失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        File file=new File("E:"+File.separator+"hello.txt");
        //判断文件是否存在
        if (file.exists()) {
            if (file.delete()){
                System.out.println("文件存在，删除成功");

            }else {
                System.out.println("文件不存在，删除失败");
            }

        } else {
           if(file.createNewFile()){

               System.out.println("文件不存在，创建成功");
           }else{

               System.out.println("文件不存在，创建失败");
           }

        }
    }
}
