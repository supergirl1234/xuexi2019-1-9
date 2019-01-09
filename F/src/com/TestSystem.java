package com;

import java.util.Properties;

public class TestSystem {
    public static void SystemProperties() {


        //系统属性
        Properties properties = System.getProperties();
        //常用的系统属性
        //user.home
        //user.dir
        //java.home
        //path.separator
        //file.separator
        String userHome = (String) properties.get("user.home");
    }

    public static void main(String[] args) {

    }
}
