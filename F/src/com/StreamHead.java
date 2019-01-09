package com;

import java.io.*;
import java.nio.file.Paths;

public class StreamHead {
    public static void code1() {
        File inputFile = Paths.get("E:", "test", "input.txt").toFile();
        File outputFile = Paths.get("E:", "test", "output.txt").toFile();
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();

        }

        FileInputStream ins = null;
        FileOutputStream out = null;
        try {

            ins = new FileInputStream(inputFile);
            out = new FileOutputStream(outputFile);
            int value = -1;
            //输入
            while ((value = ins.read()) != -1) {
                //程序中进行数据的处理
                value = value + 32;//A-a
                //输出
                out.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭数据流
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (out != null) {

                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void code2() {
        File file = Paths.get("E:", "test.txt").toFile();
        OutputStream out = null;
        try {

            out = new FileOutputStream(file);
            out.write(65);
            byte[] data = new byte[]{65, 66, 67};
            out.write(data);
            out.write(data, 2, 1);
            out.write('\n');//此处好像没起作用
            String message = "java 666";
            out.write(message.getBytes());//将内容变为字节数组
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (out != null) {

                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {
        //输出流采用自动关闭
        File file = Paths.get("E:", "test.txt").toFile();
        try (OutputStream out = new FileOutputStream(file);) {

            out.write(68);
            byte[] data = new byte[]{69, 70, 71};
            out.write(data);
            out.write(data, 2, 1);
            out.write('\n');//此处好像没起作用
            String message = "java 666";
            out.write(message.getBytes());//将内容变为字节数组
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
