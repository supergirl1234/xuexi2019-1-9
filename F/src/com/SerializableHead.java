package com;

import java.io.*;
import java.nio.file.Paths;

public class SerializableHead {
    public static void code1() {
        //1.准备序列化输出的文件
        //2.准备要参与的序列化对象
        //3.业务操作（Object-》byte[]）
        File objFile=Paths.get("E:","test","person.obj").toFile();
        //内存中的Java对象
        Person person=new Person("Jack",22,"jack@gmail.com");

        try( ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(objFile))
        ) {
            //文件中的二进制数据流
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code2() {
        File objFile=Paths.get("E:","test","person.obj").toFile();
        try ( ObjectInputStream in=new ObjectInputStream(new FileInputStream(objFile))
            ){
            Person person=(Person)in.readObject();
            System.out.println(person);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        code1();
       code2();
    }

}

class Person implements Serializable{

    private  String name;
    private  Integer age;
    private String email;

    public Person(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
