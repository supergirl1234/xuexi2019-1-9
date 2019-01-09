package com;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class TestLinkedList {

    public static void main(String[] args) {
        List<String> list=new LinkedList();

        list.add("C");
        list.add("C++");
        list.add("Ch");
        System.out.println(list);
        ((LinkedList<String>) list).addFirst("ji");
        ((LinkedList<String>) list).addLast("ssd");
        System.out.println(list);
    }
}
