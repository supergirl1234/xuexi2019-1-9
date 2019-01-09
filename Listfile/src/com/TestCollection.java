package com;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class TestCollection {

    public static void code1(){

        //线程不安全
       /* Map<String,String> map=new HashMap<>();
          map.put("1","java");*/

        //线程安全
        Map<String,String> map=Collections.synchronizedMap(new HashMap<>());
        System.out.println(map.getClass().getName());
    }
    public static void main(String[] args) {

        List<String> data=new ArrayList<>();
        for(int i=65;i<123;i++){
            data.add(String.valueOf((char)i));

        }
        System.out.print("原始数据");
        System.out.println(data);

        System.out.print("反转之后");
        //反转方法
        Collections.reverse(data);
        System.out.println(data);

        //查找
        System.out.println(data.get(0));
        int dex=Collections.binarySearch(data,"A");
        System.out.println("A的下标为："+dex);

        //乱序
        Collections.shuffle(data);
        System.out.println(data);

    }

}
