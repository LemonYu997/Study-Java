//泛型通配符     ?
package chapter06.heimaPro.demo01Generic;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 使用泛型或接口时，传递的数据中，泛型类型不确定，可以通过通配符<?>表示
 * 但是一旦使用泛型的通配符后，只能使用Object类中的共性方法，集合中元素自身方法无法使用
 *
 * 通配符的基本使用：
 * 不知道使用什么类型来接收的时候，用"?"表示未知通配符
 *
 * ?: 代表任意的数据类型
 * 使用方式：
 *      不能创建对象使用
 *      只能作为方法的参数使用
 *
 * 【注意】：此时只能接收数据，不能往集合中存储数据
 * */
public class Demo05Wildcard {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("A");
        list02.add("B");

        printArray(list01);
        printArray(list02);

        //? 不能创建对象使用
//        ArrayList<?> list03 = new ArrayList<?>();     //报错
    }

    /*
     * 定义一个方法，能遍历所有类型的ArrayList集合
     * 这时候不知道ArrayList集合使用什么数据类型，可以使用泛型的通配符 ? 来接收数据类型
     * 注意：
     *      泛型没有继承概念，所以不能设为Object
     * */
    public static void printArray(ArrayList<?> list) {
        //使用迭代器遍历集合
        //集合使用什么类型，迭代器就设为什么类型
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            //it.next()方法，取出的元素是Object类型，可以接收任意的数据类型
            Object o = it.next();
            System.out.println(o);
        }
        System.out.println("------------------");
    }
}
