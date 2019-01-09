package com.fa;

/**
 * Author:Fanleilei
 * Created:2018/12/25 0025
 */
public interface IUtil2 {

    //arg1>arg2  return >0
    //arg1=arg2  return =0
    //arg1<arg2  return <0
    Integer compare(Integer arg1,Integer arg2);


    public static void main(String[] args) {
        //匿名内部类的方式
        IUtil2 iUtil2=new IUtil2() {
            @Override
            public Integer compare(Integer arg1, Integer arg2) {
                return arg1-arg2;
            }
        };

        IUtil2 iUtil21=(arg1, arg2) -> {

            return arg1-arg2;
        };

        //类::普通方法
        IUtil2 iUtil22=Integer::compareTo;
        System.out.println(iUtil22.compare(22,23));


    }
}
