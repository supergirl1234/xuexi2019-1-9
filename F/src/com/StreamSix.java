package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

public class StreamSix {

    private OutputStream outputStream;

    public StreamSix(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public void print(String str){
        try {
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str){
        print(str);
        try {
            outputStream.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void println(int value){

        println(String.valueOf(value));
    }
    public void println(double value){

        println(String.valueOf(value));
    }
    public void println(boolean value){

        println(String.valueOf(value));
    }

    public static void main(String[] args) {

        StreamSix print=null;
        try{

            print=new StreamSix(
                    new FileOutputStream(Paths.get("E:","test","test.txt").toFile())
                    );
                    print.println("helloss");
                    print.println("10");
                    print.println("10.0D");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
