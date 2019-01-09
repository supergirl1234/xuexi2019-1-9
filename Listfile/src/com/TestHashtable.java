package com;

import java.util.Hashtable;
import java.util.Map;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class TestHashtable {

    public static void main(String[] args) {
        Map<String,String> hashtable=new Hashtable<>();

        hashtable.put("1","java");
        hashtable.put("2","ja");
        hashtable.put("3","va");
        //Hashtable中的key不能为null，否则会报NPE错误
        //Hashtable中的value也不能为null，否则会报NPE错误
        //hashtable.put(null,"hello");
        //hashtable.put("4",null);
        System.out.println(hashtable);
    }
}
