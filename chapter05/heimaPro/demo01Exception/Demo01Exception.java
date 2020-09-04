//异常
package chapter05.heimaPro.demo01Exception;

/*
 * 异常：指的是程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常停止
 * 异常本身是一个类，产生异常就是创建异常对象并抛出了一个异常对象，java处理异常的方式是中断处理
 *
 * java.lang.Throwable类是 Java 语言中所有错误或异常的超类
 * 有两个子类：
 *      public class Exception extends Throwable：编译期异常，进行编译(写代码)java程序出现的问题
 *          RuntimeException：运行期异常，java程序运行程序中出现的问题
 *          异常就相当于程序得了一个小毛病，把异常处理掉，程序可以继续执行
 *      public class Error extends Throwable：错误
 *          相当于程序得了一个无法治愈的毛病，必须修改源代码，程序才能执行
 *
 * 编译期异常有两种处理方式：
 * 1、方法后加上 throws 异常名
 *      交由虚拟机处理，出现异常程序终止运行
 * 2、try-catch
 *
 * 总结：
 * 1、异常有两种：编译期异常和运行期异常
 * 2、错误
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01Exception {
    public static void main(String[] args) /*throws ParseException*/ {
        //Exception：编译期异常，进行编译(写代码)java程序出现的问题
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      //格式化日期
        //存在ParseException异常，需要处理
        //编译期异常有两种处理方式
        //1、方法后加上 throws 异常名
        //2、try-catch
//        Date date = null;
//        try {
//            date = sdf.parse("1999-09-09");     //把字符串格式的日期，解析为Date格式的日期
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(date);
        System.out.println("------------------------------------");

        //RuntimeException：运行期异常，java程序运行程序中出现的问题
        int[] arr = {1, 2 ,3};
//        System.out.println(arr[0]);
        //没有报错，但程序运行期间会出现ArrayIndexOutOfBoundsException索引越界异常
        //这就是一个运行期异常
//        System.out.println(arr[3]);

        //处理方式：try-catch
        try {
            //可能会出现的异常代码
            System.out.println(arr[3]);     //ArrayIndexOutOfBoundsException索引越界异常
        } catch (Exception e) {
            //异常的处理逻辑
            System.out.println(e);          //java.lang.ArrayIndexOutOfBoundsException: 3
        }

        //程序异常被处理后，程序能够继续执行

        System.out.println("程序继续执行");
        System.out.println("------------------------------------");

        //Error：错误
        //OutOfMemoryError：java heap space
        //内存溢出的错误，创建的数组太大了，超出了给JVM分配的内存
//        int[] array = new int[1024 * 1024 * 1024];
        //必须修改代码，创建的数组小一点
        int[] array = new int[1024 * 1024];
    }
}
