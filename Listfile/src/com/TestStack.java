package com;

import java.util.Stack;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        System.out.println(stack);
        System.out.println("当前栈是否为空"+stack.isEmpty());

        //入栈
        stack.push("java");
        stack.push("hello");
        stack.push("best");
        System.out.println(stack);
        System.out.println("当前栈的元素个数："+stack.size());
        //栈顶元素
        System.out.println(stack.peek());
        System.out.println("栈顶是否为best："+"best".equals(stack.peek()));
       // 出栈
      /*  System.out.println( stack.pop());
        System.out.println( stack.pop());
        System.out.println( stack.pop());*/
        //如果栈空了，再出栈就会抛出异常
        //System.out.println( stack.pop());

        while(!stack.isEmpty()){
            System.out.println(stack.pop());

        }


    }
}
