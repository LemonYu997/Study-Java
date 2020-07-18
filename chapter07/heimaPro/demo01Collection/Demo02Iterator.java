//Iterator接口 迭代器的代码实现
package chapter07.heimaPro.demo01Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * java.util.Iterator接口：迭代器(对集合进行遍历)
 * 两个常用方法：
 *      boolean hasNext()：如果仍有元素可以迭代，则返回true
 *          判断集合中还有没有下一个元素，有就返回true，没有就返回false
 *      E next() 返回迭代的下一个元素，取出集合中的下一个元素
 *
 * Iterator迭代器，是一个接口，无法直接使用，需要使用Iterator接口的实现类对象，获取实现类的方式比较特殊
 * Collection接口中有一个方法，叫iterator()，这个方法返回的就是迭代器的实现类对象
 *
 * Iterator<E> iterator() 返回在此 collection的元素上进行迭代的迭代器
 *
 * 迭代器的使用步骤(重点)：
 * 1、使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收(多态)
 * 2、使用Iterator接口中的方法hasNext判断还有没有下一个元素
 * 3、使用Iterator接口中的方法next取出集合中的下一个元素
 * */
public class Demo02Iterator {
    public static void main(String[] args) {
        //创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        //往集合中添加元素
        coll.add("Jack");
        coll.add("Mercy");
        coll.add("Tom");
        coll.add("Jerry");

        /*
         * 1、使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收(多态)
         * 注意：
         *      Iterator<E>接口也是有泛型的，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型
         * */
        //多态  接口            实现类对象
        Iterator<String> it = coll.iterator();

//
//        /*
//         * 2、使用Iterator接口中的方法hasNext判断还有没有下一个元素
//         * 判断集合中还有没有下一个元素，有就返回true，没有就返回false
//         * */
//        boolean b = it.hasNext();
//        System.out.println(b);              //true
//
//        /*
//         * 3、使用Iterator接口中的方法next取出集合中的下一个元素
//         * 返回迭代的下一个元素，取出集合中的下一个元素
//         * */
//        String s = it.next();
//        System.out.println(s);             //Jack
//        System.out.println("--------");
//
//        b = it.hasNext();
//        System.out.println(b);              //true
//        s = it.next();
//        System.out.println(s);              //Mercy
//        System.out.println("--------");
//
//        b = it.hasNext();
//        System.out.println(b);              //true
//        s = it.next();
//        System.out.println(s);              //Tom
//        System.out.println("--------");
//
//        b = it.hasNext();
//        System.out.println(b);              //true
//        s = it.next();
//        System.out.println(s);              //Jerry
//        System.out.println("--------");
//
//        b = it.hasNext();
//        System.out.println(b);              //false
//        //没有元素再取出元素，会抛出没有元素异常NoSuchElementException
////        s = it.next();
////        System.out.println(s);              //NoSuchElementException异常
//        System.out.println("--------");

        /*
         * 发现使用迭代器取出集合元素的代码，是一个重复的过程
         * 所以可以使用循环优化，不知道集合中有多少元素，使用while循环
         * 循环结束的条件，hashNext方法false
         * */
        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
        System.out.println("--------");

        //使用for循环
        for(Iterator<String> it2 = coll.iterator(); it2.hasNext();) {
            String e = it2.next();
            System.out.println(e);
        }
    }
}
