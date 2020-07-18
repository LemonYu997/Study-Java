//集合Collection
package chapter07.heimaPro.demo01Collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 集合：集合是java中提供的一种容易，可以用来存储多个数据
 *
 * 集合和数组的区别：
 * 1、数组的长度是固定的，集合的长度是可变的
 * 2、数组中存储的是同一类型的元素，可以存储基本数据类型值
 *    集合存储的都是对象，而且对象的类型可以不一致，在开发中对象多的时候，使用集合存储
 *
 * 集合框架：看OneNote截图
 *
 * java.util.Collection接口：
 * 所有单列集合的最顶层的接口，里边定义了所有单列集合共性的方法
 * 任意的单列集合都可以使用Collection接口中的方法
 * Collection常用功能(共有方法)：
 * 1、public boolean add(E e)：把给定的对象添加到当前集合中
 * 2、public void clear()：清空集合中所有的元素
 * 3、public boolean remove(E e)：把给定的对象在当前集合中删除
 * 4、public boolean contains(E e)：判断当前集合中是否包含给定的对象
 * 5、public boolean isEmpty()：判断当前集合是否为空
 * 6、public int size()：返回集合中元素的个数
 * 7、public Object[] toArray()：把集合中的元素，存储到数组中
 * */
public class Demo01Collection {
    public static void main(String[] args) {
        //创建集合对象，可以使用多态
        Collection<String> coll = new ArrayList<>();      //可以运行
        //方法是通用的，换另一种集合仍然能正常运行
//        Collection<String> coll = new HashSet<>();          //也可以运行
        System.out.println(coll);       //[]        重写了toString方法

        /*
         * public boolean add(E e)：把给定的对象添加到当前集合中
         * 返回值是一个boolean值，一般都返回true，所以可以不用接收
         */
        boolean b1 = coll.add("Jack");
        System.out.println("b1:" + b1);      //b1：true
        System.out.println(coll);            //[Jack]
        coll.add("Tom");
        coll.add("Jerry");
        coll.add("Mercy");
        coll.add("Lisa");
        System.out.println(coll);           //[Jack, Tom, Jerry, Mercy, Lisa]
        System.out.println("------------------------------------");

        /*
         * public boolean remove(E e)：把给定的对象在当前集合中删除
         * 返回值是一个boolean值，集合中存在元素，删除元素，返回true
         * 集合中不存在元素，删除失败，返回false
         * */
        boolean b2 = coll.remove("Jerry");
        System.out.println("b2:" + b2);     //b2:true
        boolean b3 = coll.remove("Mack");
        System.out.println("b3:" + b3);     //b3:false
        System.out.println(coll);           //[Jack, Tom, Mercy, Lisa]
        System.out.println("------------------------------------");

        /*
         * public boolean contains(E e)：判断当前集合中是否包含给定的对象
         * 包含返回true，不包含返回false
         * */
        boolean b4 = coll.contains("Mercy");
        System.out.println("b4:" + b4);     //b4:true
        boolean b5 = coll.contains("Mack");
        System.out.println("b5:" + b5);     //b5:false
        System.out.println("------------------------------------");

        /*
         * public boolean isEmpty()：判断当前集合是否为空
         * 为空返回true，不为空返回false
         * */
        boolean b6 = coll.isEmpty();
        System.out.println(b6);             //false
        System.out.println("------------------------------------");

        /*
         * public int size()：返回集合中元素的个数
         * */
        int size = coll.size();
        System.out.println(size);           //4
        System.out.println("------------------------------------");

        /*
         * public Object[] toArray()：把集合中的元素，存储到数组中
         * 由于数组中类型是各种各样的，因此使用Object[]作为返回值
         * */
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("------------------------------------");

        /*
         * public void clear()：清空集合中所有的元素
         * 但是不删除集合，集合还存在
         * */
        coll.clear();
        System.out.println(coll);           //[]
        System.out.println(coll.isEmpty()); //true
    }
}
