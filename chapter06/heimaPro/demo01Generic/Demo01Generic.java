//泛型
package chapter06.heimaPro.demo01Generic;

/*
 * 泛型：一种未知的数据类型，当不知道使用什么数据类型的时候，可以使用泛型
 * 泛型也可以看出是一个变量，用来接收数据类型
 *      E e : Element   元素
 *      T t : Type      类型
 * 例如：ArrayList<E>
 * */

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01Generic {
    public static void main(String[] args) {
        show01();
        show02();
    }

    /*
     * 创建集合对象，不使用泛型
     * 好处：
     *      集合不适用泛型，默认是Object类型，可以存储任意类型的数据
     * 弊端：
     *      集合不安全，会引发异常
     * */
    private static void show01() {
        ArrayList list = new ArrayList();   //默认存储Object
        list.add("abc");
        list.add(24);

        //使用迭代器遍历list集合
        //获取迭代器，迭代器类型跟随泛型，这里是Object，默认不写
        Iterator it = list.iterator();
        //使用迭代器中的hasNext和Next遍历集合
        while(it.hasNext()) {
            //取出元素也是Object类型
            Object o = it.next();
            System.out.println(o);

            //想要使用String类特有的方法，length获取字符串的长度，不能使用
            //原因：多态 Object obj = "abc";
            //解决：向下转型
            //抛出了ClassCastException类型转换异常，不能把Integer类型转换为String类型
//            String s = (String)o;
//            System.out.println(s.length());
        }
        System.out.println("-----------------");
    }

    /*
     * 创建集合对象，使用泛型
     * 好处：
     *      1、避免类型转换的麻烦，存储的是什么类型，取出的就是什么类型
     *      2、把运行期异常(代码运行之后会抛出的异常)，提升到了编译期(写代码时候的报错)
     * 弊端：
     *      泛型是什么类型，只能存储什么类型的数据
     * */
    private static void show02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
//        list.add(1);        //报错

        //使用迭代器遍历list集合
        //获取迭代器，迭代器类型跟随泛型，这里是String
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            //跟随泛型
            String s = it.next();
            //可以使用泛型对应类型特有的功能
            System.out.println(s + " -> " + s.length());
        }
    }
}
