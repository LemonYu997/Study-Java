package chapter07.heimaPro.demo03List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * java.util.List接口 extends Collection接口
 * List接口的特点：
 *      1、有序的集合，存储元素和取出元素的顺序是一致的(存储123 取出123)
 *      2、有索引，包含了一些带有索引的方法
 *      3、允许存储重复的元素
 *
 * List接口中带索引的方法：
 *      void add(int index, E element) 在列表的指定位置插入指定元素
 *      E get(int index) 返回列表中指定位置的元素
 *      E remove(int index) 移除列表中指定位置的元素
 *      E set(int index, E element) 用指定元素替换列表中指定位置的元素
 *
 * 注意：
 *      操作索引的时候，一定要防止
 *      IndexOutOfBoundsException：索引越界异常
 *      ArrayIndexOutOfBoundsException：数组索引越界异常
 *      StringIndexOutOfBoundsException：字符串索引越界异常
 * */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合对象，多态
        List<String> list = new ArrayList<>();
        //使用add方法往集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        //打印集合
        //有序存储，输入和输出顺序一致
        System.out.println(list);       //[a, b, c, d, a]  不是地址，重写了toString方法

        //void add(int index, E element) 在列表的指定位置插入指定元素
        //在c和d之间添加一个 CLX
        list.add(3,"CLX");
        System.out.println(list);       //[a, b, c, CLX, d, a]

        //E remove(int index) 移除列表中指定位置的元素
        //移除元素 c
        String removeE = list.remove(2);
        System.out.println("被移除的元素: " + removeE);    //被移除的元素: c
        System.out.println(list);       //[a, b, CLX, d, a]

        //E set(int index, E element) 用指定元素替换列表中指定位置的元素
        //把最后一个a，替换为A
        String setE = list.set(4, "A");
        System.out.println("被替换的元素: " + setE);      //被替换的元素: a
        System.out.println(list);       //[a, b, CLX, d, A]

        System.out.println("------------------------");

        //List集合遍历有三种方式
        //1、使用普通的for循环
        for (int i = 0; i < list.size(); i++) {
            //E get(int index) 返回列表中指定位置的元素
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("------------------------");

        //2、使用迭代器遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("------------------------");

        //3、增强for循环
        for (String s : list) {
            System.out.println(s);
        }

//        //索引越界异常 IndexOutOfBoundsException
//        String r = list.get(5);     //没有5索引 IndexOutOfBoundsException
//        System.out.println(r);
    }
}
