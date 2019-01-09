package com;

import java.util.*;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class TestSet {


    //无序排序
    public static void code1(){

        Set<String> set=new HashSet<>();


        set.add("C");
        set.add("C++");
        set.add("java");
        set.add("Go");

        System.out.println(set);

        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }

        //判断元素是否存在

        System.out.println(set.contains("java"));//true

    }

    //有序排序
    public static void code2() {

      //1.TreeSet无参数构造方法，元素排序使用元素的排序策略
        //2.TreeSet有参数，传递比较器的实例化对象，采用自定义的

        //这个地方的比较器不太懂
        Set<String> set=new TreeSet<>(

                (o1,o2)->o1.compareTo(o2)*-1  //这是反序
        );

        set.add("java");
        set.add("C");
        set.add("C++");
        set.add("Go");

        System.out.println(set);

        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }

        //判断元素是否存在

        System.out.println(set.contains("java"));//true

    }

    public static void code3() {
        Set<Person> set=new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.compareTo(o2)*-1;
            }
        }


        );
        set.add(new Person("Jack",12));
        set.add(new Person("Alice",13));


        for(Person p:set){
            System.out.println(p);

        }
    }

    public static void code4() {
        Set<Person> set=new TreeSet<>();
        set.add(new Person("Jack",12));
        set.add(new Person("Alice",13));

        //如果用foreach方式遍历集合（List、Set...），则不能对里面的元素就进行添加、修改、删除等操作，否则会报错
        //如果想要在遍历时对集合进行操作，用迭代器iterator

        //下面这个有问题
        /*Iterator<Person> iterator=set.iterator();
        while(iterator.hasNext()){
            set.add(new Person("Tom",14));
            System.out.println(iterator.next());

        }*/

    }

    public static void main(String[] args) {
        Vector<String> vector=new Vector<>();

        vector.add("C");
        vector.add("C++");
        vector.add("Python");

        Enumeration enumeration=vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());


        }
    }

}



class Person implements  Comparable<Person>{

    private  String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    //手工写的，还可以用快捷键Alt+Insert,自动生成equals和hashCode,这两个是成双成对出现的
    //equals参与判断的属性都要参与hashCode的计算
  /*  @Override
    public boolean equals(Object obj) {
        if (obj==null){

            return false;

        }
        if(this==obj){
            return true;

        }
        if(obj instanceof Person){
            Person that=(Person) obj;
            return this.getName().equals(that.getName())
                    &&
                    this.getAge().equals(that.getAge());

        }
        return false;
    }*/


    //equals和hashCode,这两个是成双成对出现的,要一起使用
    //equals参与判断的属性都要参与hashCode的计算
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public int compareTo(Person o2) {

        return this.age-o2.getAge();
    }
}
