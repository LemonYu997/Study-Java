//增强for循环 foreach
package chapter07.heimaPro.demo01Collection;

import java.util.ArrayList;

/*
 * JDK1.5+ 之后增加的高级for循环，用来遍历数组和集合
 * 内部原理是一个Iterator迭代器，所以遍历的过程中，不能对集合中的元素进行增删操作
 * 格式：
 * for(集合/数组数据类型 变量名 : Collection集合名 or 数组名) {
 *      //sout
 * }
 *
 * 增强for循环：底层使用迭代器，使用for循环的格式，简化迭代器的书写
 *
 * public interface Collection<E>extends Iterable<E>：所有的单列集合都可以使用增强for
 * public interface Iterable<T>实现这个接口允许对象成为 "foreach" 语句的目标。
 *
 * 注意事项：
 * 1、增强for循环必须有被遍历的目标
 * 2、目标只能是Collection或者数组
 * 3、增强for仅仅作为遍历操作出现
 * */
public class Demo03ForEach {
    public static void main(String[] args) {
        demo01();
        demo02();
    }

    //增强for循环遍历数组
    private static void demo01() {
        int[] array = {1, 2, 3, 4, 5};
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("----------------");
    }

    //使用增强for循环遍历集合
    private static void demo02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------");
    }
}
