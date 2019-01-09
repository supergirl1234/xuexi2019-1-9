package com.fa;

import java.util.function.*;

/**
 * Author:Fanleilei
 * Created:2018/12/25 0025
 */
public class Test1 {

    //功能型函数接口
    public static void code1() {



        //第一个是入参，第二个是返回值；即Object是入参的类型，String是返回值的类型
        Function<Object,String> function =(value)->{


            return  value.toString();

        };
        //String result=function.apply("Hello world");
        //System.out.println(result);


        function=String::valueOf;
        String result=function.apply(new Person("tom",13));
        System.out.println(result);

        //参数确定为int，返回类型不确定
        IntFunction<String> intFunction=String::valueOf;
        System.out.println(intFunction.apply(100));
    }


    //供给型函数接口
    public static void code2() {

        Supplier<Person> supplier=()->{

            return new Person("Alice",19);
        };

        System.out.println(supplier.get());


        Supplier<String> supplier1="Hello"::toUpperCase;
        System.out.println(supplier1.get());
    }



    //将功能型和供给型结合在一起使用
    public static void code3() {

        //y=f(x)
        //x=g()
        Function<Supplier<Person>,String>  function=(s)->{
            return s.get().toString();

        };

        Supplier<Person> s=()->{

            return new Person("Alice",18);
        };

        String rs=function.apply(s);
        System.out.println(rs);

        //Stream  ,并发，并行计算，现代编程语言

    }


    //消费型函数接口(没有返回值)
    public  void code4() {

       Consumer<String> consumer=(str)->{

           System.out.println(str);
       };

       consumer.accept("Hello world");


        //传递数组
       Consumer<String[]> consumer1=(strs)->{

           for(String item:strs){

               System.out.println(item);
           }
       };
       consumer1.accept(new String[]{"a","b","c"});

    }
    public static void main(String[] args) {
        Predicate<String> predicate ="Hello"::endsWith;
       boolean rs= predicate.test("o");//"Hello".endsWith("o");是不是以“o”结尾的
        System.out.println(rs);//true


        //参数Object类型，判断 如果参数对象是由Person类实例化的，return true，否则 false

        Predicate<Object> predicate1=(obj)->{


            return obj instanceof  Person;
        };
        System.out.println(predicate1.test("hello"));//false
        System.out.println(predicate1.test(new Person("ads",12)));//true


        predicate1 ="hello"::equals;
        System.out.println(predicate1.equals("hello"));

    }
}
