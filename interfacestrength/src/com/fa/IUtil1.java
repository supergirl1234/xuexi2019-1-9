package com.fa;

/**
 * Author:Fanleilei
 * Created:2018/12/25 0025
 */
public interface IUtil1 {

    //()->String
    String convert();

    public static void main(String[] args) {
        IUtil1 iUtil1=()->{

            return "hello";
        };
        System.out.println(iUtil1.convert());


        IUtil1 iUtil2=()->{

            return "world";
        };
        System.out.println(iUtil2.convert());

        //String->大写
        System.out.println("hello".toUpperCase());


        //实例化对象::普通方法
        IUtil1 iUtil3="Hello"::toUpperCase;
        System.out.println(iUtil3.convert());


        String str="java is best";
        iUtil3=str::toUpperCase;
        System.out.println(iUtil3.convert());

        print("Hello"::toUpperCase);
        print("Hello"::toString);
        print("Hello"::trim);

        print(new Person("Jack",12)::toString);

    }

    public static void print(IUtil1 iUtil) {
        System.out.println(iUtil.convert());
    }



    class Person{


        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
