package com;

/**
 * Author:Fanleilei
 * Created:2018/12/16 0016
 */
public class TestMessage {
    public static void cod1() {
        Message qq=new QQMessage() ;
        Message msn=new MSNMessage() ;

        qq.chat();
        qq.transportFile();


        msn.chat();
        msn.transportFile();

        MSNMessage msnMessage=new MSNMessage();
        msnMessage.chat();
        msnMessage.transportFile();

        Message.print();

    }


    public static void main(String[] args) {

        //1.Lambda表达式：如果抽象方法的实现中只有一条命令，大括号可以省略
        //2.Lambda表达式：如果抽象方法的参数只有一个参数，那么参数列表的括号可以省略
        //3.Lambda表达式：如果抽象方法的实现中有返回值，并且只有一条语句，那么这条语句的结果就是返回值
        //4.Lambda表达式：(参数列表)->{   实现内容  };
        // 注意：在Lambda表达式所在作用域下，防止参数列名中的参数名和作用域中的其它变量名冲突

        //5.Lambda表达式：接口有且只有一个抽象方法（大前提）,使用 @FunctionInterface注解标注接口是一个函数接口



        Message message=new Message() {
            @Override
            public void chat() {
                System.out.println("匿名内部类实现的message聊天");
            }
        };

        //Lambda表达式
        // Message message= () -> System.out.println("匿名内部类实现的message聊天");
        message.chat();

        Message1 message1= message2 -> {
            System.out.println(message2);
            System.out.println("....");
        };



        Message2 message2= (message3, sub) -> {
            System.out.println(message3);
            System.out.println(sub);
        };


        //标准写法  不简写
        Message3 message3= (message4, sub) -> {
            System.out.println(message4 +sub);
            return message4 +sub;
        };



        Message3 message4= (message5, sub) -> {

            return message5 +sub;
        };

        System.out.println(message4.chat("Hello","World"));



      //因为Message4中有两个抽象方法，所以不能将其转变为Lambda表达式了

    //  Message4 message41=(args1,args2)-> {
    //       String rs=args1+args2;
    //       return rs;
    //   };
    //  System.out.println(message41.chat("java","web"));

        Message4 message5=new Message4() {
            @Override
            public String chat(String message, String sub) {
                return null;
            }

            @Override
            public void print() {

            }
        };
    }
}
