package com;

import java.util.*;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class TestMap {

    public  static void code1(){


        //HashMap的key和value是可以为null
        Map<String,String> map=new HashMap<>();
        map.put("1","C");
        map.put("2","C++");
        map.put("3","Go");
        map.put("4","java");

        System.out.println(map.containsKey("1"));//true
        System.out.println(map.containsKey("5"));//false
        System.out.println(map.get("2"));//C++
        System.out.println(map.get("5"));//null


        //HashMap的key和value是可以为null
        map.put("null","key is null");
        map.put("5","null");
        System.out.println(map.size());//6

        map.put("5","php");
        System.out.println(map.get("5"));


        //获取map中的所有key
        System.out.println("获取Map中的所有key");
        Set<String> key=map.keySet();
        for (String p:key){

            System.out.println(p);
        }

        System.out.println("输出key=value");
        for (String p:key){

            System.out.println(p+"="+map.get(p));
        }



        //获取所有的value值
        System.out.println("输出所有的value值");

        Collection<String> collection=map.values();
        for(String value:collection){

            System.out.println(value);
        }


        System.out.println("通过Entry遍历map");
        Set<Map.Entry<String,String>> set= map.entrySet();
        //set没有下标，所以没有for循环
        //用foreach 和iterator来进行遍历
       /* Iterator<Map.Entry<String,String>> iterator=set.iterator();
        while(iterator.hasNext()){

            Map.Entry<String,String> entry=iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/

        System.out.println();

       /* for(Map.Entry<String,String> p:set){
            System.out.println(p.getKey()+":"+p.getValue());

        }*/

        for(Map.Entry<String,String> p:map.entrySet()){
            System.out.println(p.getKey()+":"+p.getValue());

        }
    }
    public static void main(String[] args) {


        //1.如果key是系统（JDK，第三方）定义的类排序规则，有可能已经定义完成，如果要修改，可以通过TreeMap的构造方法
        // 传入比较器（Comparator）接口的实现类对象（Lambda表达式）
        //2.如果key是自定义的类，可以实现比较接口Comparable,也可以不去实现，在使用的时候指定比较器（Comparator）接口的实现类对象
        //3.采用使用时指定Comparator方式比较灵活
        Map<Integer,String> map=new TreeMap<>((o1,o2)->
        o1.compareTo(o2)*-1);//可以自己写一个排序接口

        //TreeMap是一个可以排序的Map子类，它是按照Key的内容排序的。
        map.put(1,"java");
        map.put(3,"Go");
        map.put(2,"C++");
        map.put(4,"C++");//从小到大的排序

        System.out.println(map);
    }
}
