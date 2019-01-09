import java.util.*;

/**
 * Author:Fanleilei
 * Created:2018/12/27 0027
 */
public class List1 {


    //ArrayList的基本使用
    public  static void code1(){


        //实例化一个ArrayList对象，List类型
        List<String> list1=new ArrayList<>();
        list1.add("Java");
        list1.add("C");
        list1.add("C++");
        list1.add("Python");
        list1.add("Python");//List可以重复元素
        System.out.println(list1);

        list1.add(0,"GO");
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        list1.remove(0);
        list1.remove("C");
        System.out.println(list1);

        list1.addAll(list1);
        System.out.println(list1);



        for(int i=0;i<list1.size();i++){

            System.out.print(list1.get(i));
            if(i<list1.size()-1){

                System.out.print(",");
            }

        }
        System.out.println();


        //迭代器
        Iterator<String>  iterator=list1.iterator();
        while(iterator.hasNext()){

            System.out.print(iterator.next());
            System.out.print(",");
        }


        System.out.println();

        Object[] elementArray=list1.toArray();//toArray()将里面的元素转化为数组
        //此方法就相当于下面的算法

        //String elementArray=new String[list1.size()];
        //for(int i=0;i<list1.size();i++){
        //     elementArray[i]=list1.get(i);
        // }

        //还有一个带参数的toArray()方法

        String[] elementarry2=new String[list1.size()];//如果数组的长度<list1的长度，会使数组元素全部变成null
        list1.toArray(elementarry2);
        //System.out.println(Arrays.toString(elementarry2));

        //不直接使用Collection接口
        //Collection collection=list1;
        //collection.toArray()要传一个Object数组，不能使用泛型了


    }

    //集合与java的简单类
    public static void code2() {
        List<Person> people=new ArrayList<>();
        people.add(new Person("Aun",12));
        people.add(new Person("Alice",13));
        people.add(new Person("Jack",14));
        for (Person p:people){

            System.out.println(p);
        }

        System.out.println(people.contains(new Person("Aun",12)));//返回Boolean  //false
        //contains比较的不是内容，而是对象
        //如果覆写了equals方法，则就返回true
        //System.out.println(people.contains("Jack"));//false


        //remove删除的也是同一个对象，那这样子就不好删除了
        //所以要覆写equals方法
       // System.out.println(people.remove("Jack"));//false

    }

    //Vector
    public static void code3() {
        List<String> vector=new Vector<>();
        vector.add("java");
        vector.add("C");
        System.out.println(vector);
    }


    public static void code4() {
        List<String> list=new ArrayList<>();
        list.add("C");
        list.add("C++");
        list.add("Java");

        // ListIterator
        ListIterator<String> iterator=list.listIterator();
        while(iterator.hasNext()){

            System.out.print(iterator.next());
            iterator.add(",");
            //System.out.print(",");                 //如果想要对元素进行遍历并删除，就用迭代器iterator，否则其他的可能会出错
        }

        System.out.println();

        for(String str:list){
            System.out.print(str);

        }

        System.out.println();

        while(iterator.hasPrevious()){

            System.out.print(iterator.previous());
            System.out.print(",");
        }
    }

    public static void main(String[] args) {

        //数据结构：List->ArrayList
        //1.ArrayList的数据是通过数组存放的
        //2.ArrayList的无参默认构造方法实例化，存储数据的数组初始化是在第一次添加元素时进行初始化的,称为延时加载（Lazy Lode）-扩容-默认容量10
        //3.Arraylist的初始化容量的构造方法实例化，存储数据的数组立即初始化
        List<String>  list=new ArrayList<>();
    }
}


class Person{

    private  String name;
    private Integer age;   //这个地方，要用Integer,不能用int，否则下面的覆写equals方法处的 this.getAge().equals(that.getAge());会出错

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
    //equals参与判断的属性都要参与hashCode的计算，否则会没办法唯一的表示该对象
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
}