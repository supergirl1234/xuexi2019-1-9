package com.fa;

/**
 * Author:Fanleilei
 * Created:2018/12/16 0016
 */
public interface IUtil {

    //Integer->String
    String convert(Integer value);

    public static void main(String[] args) {
        IUtil iUtil=(value)->{

            return String.valueOf(value);
        };
        System.out.println(iUtil.convert(10));

        //类::静态方法
        IUtil iUtil1=String::valueOf;
        System.out.println(iUtil1.convert(10));
    }
}
