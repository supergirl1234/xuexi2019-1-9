package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author:Fanleilei
 * Created:2018/12/28 0028
 */
public class TestProperties {

    public static void main(String[] args) {

        //*.properties  称之为属性文件
        //Properties   称之为属性类
        //*.properties->Properties
        //读取文件：load->Properties     InputStream/Reader
        //写入文件：store->*.properties    OutputStream/Writer
        Properties properties=new Properties();

        try {
            //1.通过FileInputStream
            //properties.load(new FileInputStream("D:\\workspace\\Listfile\\src\\com\\hello.properties"));

            //2.通过ClassLoader的方式读取属性文件时，指定包路径
            InputStream inputStream=TestProperties.class.
                    getClassLoader().getResourceAsStream("com/hello.properties");
            properties.load(inputStream);

            System.out.println(properties.getProperty("java"));
            System.out.println(properties.get("java"));
            System.out.println(properties.getProperty("php"));
            System.out.println(properties.getProperty("php","php是最好的"));
            //getProperty(key)
            //getProperty(key,defaultValue)


            //1.put
            //2.setProperity(建议使用这个)
            properties.put("php","php bu");
            properties.setProperty("php","php ppd");

            //存储
            /*properties.store(new FileOutputStream("D:\\workspace\\Listfile\\src\\com\\hello.properties"),
                    "写入数据");*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
