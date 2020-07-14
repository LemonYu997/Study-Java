//ArrayList常用方法
package chapter02.heima.demo04Array;

import java.util.ArrayList;

/*
 * ArrayList常用方法有：
 *
 * public boolean add(E e): 向集合当中添加元素，参数的类型和泛型一致
 * 备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用
 * 但是对于其他集合来说，add添加动作不一定成功。
 *
 * public E get(int index): 从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素
 *
 * public E remove(int index): 从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素
 *
 * public int Size()：获取集合的尺寸长度，返回值是集合中包括的元素个数
 * */

public class Demo03ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);                           //[]

        //向集合当中添加元素：add
        boolean success = list.add("Jack");
        System.out.println(list);                           //[Jack]
        System.out.println("添加的动作是否成功：" + success); //添加的动作是否成功：true

        list.add("Tom");
        list.add("Jerry");
        list.add("Mercy");
        System.out.println(list);                              //[Jack, Tom, Jerry, Mercy]

        //从集合中获取元素：get，索引值从0开始计算
        String name = list.get(2);
        System.out.println("第2号索引位置：" + name);           //第2号索引位置：Jerry

        //从集合中删除元素：remove，索引值从0开始计算
        String whoRemoved = list.remove(3);
        System.out.println("被删除的人是谁：" + whoRemoved);    //被删除的人是谁：Mercy
        System.out.println(list);                             //[Jack, Tom, Jerry]

        //获取集合的长度尺寸，即其中元素的个数
        int size = list.size();
        System.out.println("集合的长度是：" + size);           //集合的长度是：3
    }
}
