//LinkedList集合
package chapter07.heimaPro.demo03List;

import java.util.LinkedList;

/*
 * java.util.LinkedList集合 implements List 接口
 * LinkedList集合的特点：
 *      1、底层是一个链表结构：查询慢，增删快
 *      2、里边包含了大量操作首尾元素的方法
 *      注意：使用LinkedList集合特有的方法，不能使用多态
 *
 *      public void addFirst(E e) 将指定元素插入此列表的开头
 *      public void addLast(E e) 将指定元素添加到此列表的结尾
 *      public void push(E e) 将元素推入此列表所表示的堆栈    此方法等效于 addFirst(E)
 *
 *      public E getFirst() 返回此列表的第一个元素
 *      public E getLast() 返回此列表的最后一个元素
 *
 *      public E removeFirst() 移除并返回此列表的第一个元素
 *      public E removeLast() 移除并返回此列表的最后一个元素
 *      public E pop() 从此列表所表示的堆栈处弹出一个元素    此方法等效于 removeFirst()
 *
 *      public boolean isEmpty() 如果列表不包含元素，则返回true
 * */
public class Demo02LinkedList {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
    }

    /*
     * 元素的添加操作
     * public void addFirst(E e) 将指定元素插入此列表的开头
     * public void addLast(E e) 将指定元素添加到此列表的结尾
     * public void push(E e) 将元素推入此列表所表示的堆栈
     * */
    private static void show01() {
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);     //[a, b, c]

        //public void addFirst(E e) 将指定元素插入此列表的开头
        linked.addFirst("0");
        System.out.println(linked);     //[0, a, b, c]

        //public void push(E e) 将元素推入此列表所表示的堆栈
        //此方法等效于 addFirst(E)
        linked.push("www");
        System.out.println(linked);     //[www, 0, a, b, c]

        //public void addLast(E e) 将指定元素添加到此列表的结尾，等效于add()
        linked.addLast("com");
        System.out.println(linked);     //[www, 0, a, b, c, com]

        System.out.println("-----------------------------");
    }

    /*
     * 元素get操作
     * public E getFirst() 返回此列表的第一个元素
     * public E getLast() 返回此列表的最后一个元素
     * */
    private static void show02() {
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);     //[a, b, c]

//        //如果清空集合中的元素
//        linked.clear();
//        //之后再调用getFirst或getLast方法会产生NoSuchElementException异常
//        String first = linked.getFirst();         //NoSuchElementException异常

        //添加一个判断
        //public boolean isEmpty() 如果列表不包含元素，则返回true
        //如果列表不为空
        if (!linked.isEmpty()) {
            String first = linked.getFirst();
            String last = linked.getLast();
            System.out.println("First: " + first);      //First: a
            System.out.println("Last: " + last);        //Last: c
        }

        System.out.println("-----------------------------");
    }

    /*
     * 元素删除操作
     * public E removeFirst() 移除并返回此列表的第一个元素
     * public E removeLast() 移除并返回此列表的最后一个元素
     * public E pop() 从此列表所表示的堆栈处弹出一个元素    此方法等效于 removeFirst()
     * */
    private static void show03() {
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);     //[a, b, c]

//        String first = linked.removeFirst();
        String first = linked.pop();        //等效于 removeFirst()
        System.out.println("移除的第一个元素: " + first);
        String last = linked.removeLast();
        System.out.println("移除的最后一个元素: " + last);
        System.out.println(linked);     //[b]
    }
}
