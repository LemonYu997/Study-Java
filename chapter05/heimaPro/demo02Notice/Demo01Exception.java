//异常的注意事项
package chapter05.heimaPro.demo02Notice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 多个异常使用捕获又该如何处理？
 * 1、多个异常分别处理
 * 2、多个异常一次捕获，多次处理
 * 3、多个异常一次捕获，一次处理
 *
 * 异常的注意事项：
 * 1、运行时异常被抛出可以不处理，既不捕获也不声明抛出
 * 2、如果finally有return语句，永远返回finally中的结果，避免该情况
 * 3、如果父类抛出了多个异常，子类覆盖父类方法时，抛出和父类相同的异常或者是父类异常的子类或者不抛出异常
 * 4、父类方法没有抛出异常，子类覆盖该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
 * 5、在try...catch后可以添加finally代码块，其中的代码一定会被执行，通常用于资源回收
 * */
public class Demo01Exception {
    public static void main(String[] args) {
        //1、多个异常分别处理
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]); //ArrayIndexOutOfBoundsException: 3
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            List<Integer> list = new ArrayList<>();
            Collections.addAll(list, 1, 2, 3);
            //集合的索引越界异常
            System.out.println(list.get(3));    //IndexOutOfBoundsException: Index: 3, Size: 3
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        System.out.println("后续代码!");

//        java.lang.ArrayIndexOutOfBoundsException: 3
//        java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
//        后续代码!
        System.out.println("-------------------------------------------------------");

        //2、多个异常一次捕获，多次处理
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]); //ArrayIndexOutOfBoundsException: 3
            List<Integer> list = new ArrayList<>();
            Collections.addAll(list, 1, 2, 3);
            System.out.println(list.get(3));    //IndexOutOfBoundsException: Index: 3, Size: 3
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("后续代码!");
        System.out.println("-------------------------------------------------------");

        //捕获了第一个异常就直接跳出了
//        java.lang.ArrayIndexOutOfBoundsException: 3
//        后续代码!

        /*
         * 一个try多个catch注意事项：
         * catch里边定义的异常变量，如果有子父类关系，子类的异常变量必须写在上边，否则就会报错
         * ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
         * */
//        try {
//            int[] arr = {1, 2, 3};
//            System.out.println(arr[3]); //ArrayIndexOutOfBoundsException: 3
//            List<Integer> list = new ArrayList<>();
//            Collections.addAll(list, 1, 2, 3);
//            System.out.println(list.get(3));    //IndexOutOfBoundsException: Index: 3, Size: 3
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println(e);
//        } catch (ArrayIndexOutOfBoundsException e) {              //报错！！！！
//            System.out.println(e);
//        }


        //3、多个异常一次捕获，一次处理
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]); //ArrayIndexOutOfBoundsException: 3
            List<Integer> list = new ArrayList<>();
            Collections.addAll(list, 1, 2, 3);
            System.out.println(list.get(3));    //IndexOutOfBoundsException: Index: 3, Size: 3
        } catch (IndexOutOfBoundsException e) {
            //ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
            //IndexOutOfBoundsException能够接收Try中的两种异常
            System.out.println(e);
        }
        System.out.println("后续代码!");
        System.out.println("-------------------------------------------------------");

//        java.lang.ArrayIndexOutOfBoundsException: 3
//        后续代码!

        //运行时异常被抛出可以不处理，既不捕获也不声明抛出
        //默认给虚拟机处理，终止程序，什么时候不抛出运行时异常了，再来继续执行程序
        int[] arr = {1, 2, 3};
        System.out.println(arr[3]); //ArrayIndexOutOfBoundsException: 3
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3);
        System.out.println(list.get(3));    //IndexOutOfBoundsException: Index: 3, Size: 3
        System.out.println("后续代码!");

//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
//            at chapter05.heimaPro.demo02Notice.Demo01Exception.main(Demo01Exception.java:105)
    }
}
