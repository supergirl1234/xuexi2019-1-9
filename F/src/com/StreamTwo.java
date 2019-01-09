package com;

public class StreamTwo  implements   AutoCloseable{
    public void print(){

        System.out.println("打印");
    }
    public void close() throws Exception{
        System.out.println("关闭");
    }

    public static void main(String[] args){
        /*StreamTwo p1=new StreamTwo();
        p1.print();
        try{

            p1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //AutoCloseable的close能够被自动调用
        try( StreamTwo p2=new StreamTwo();){

            p2.print();
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*StreamTwo p3=null;
        try{

           p3= new StreamTwo();
           p3.print();
        }catch(Exception e){

        }finally{

            //自己关闭对象
            if(p3!=null){
                try {
                    p3.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }*/


    }
}
