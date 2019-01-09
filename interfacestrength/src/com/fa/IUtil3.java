package com.fa;

/**
 * Author:Fanleilei
 * Created:2018/12/25 0025
 */
public interface IUtil3 {

    Person createPerson(String name,int age);

    public static void main(String[] args) {

        //匿名内部类
        IUtil3 iUtil3=new IUtil3() {
            @Override
            public Person createPerson(String name, int age) {
                return new Person(name,age);
            }
        };


        Person person=iUtil3.createPerson("Tom",13);
        System.out.println(person.toString());

        System.out.println(iUtil3.createPerson("Apple",12));

        IUtil3 iUtil31=(name,age)->{

            return new Person(name,age);
        };

        //构造方法引用
        IUtil3 iUtil32=Person::new;
        Person person1=iUtil3.createPerson("Tom",14);
        System.out.println(person1.toString());
    }


}

    class Person {


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