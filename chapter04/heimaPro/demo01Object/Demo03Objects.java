//Objects类中的equals方法
package chapter04.heimaPro.demo01Object;

import java.util.Objects;

/*
 * JDK7中添加了一个Objects工具类，提供了一些方法来操作对象，它由一些静态的实用方法组成
 * 这些方法是null-save(空指针安全的)或null-tolerant(容忍空指针的)，
 * 用于计算对象的hashcode、返回对象的字符串表示形式、比较两个对象
 *
 * 在比较两个对象时，Object的equals方法容易抛出空指针异常，而Objects类中的equals方法就优化了这个问题。
 * 方法如下：
 * public static boolean equals(Object a, Object b)：判断两个对象是否相等
 * */
public class Demo03Objects {
    public static void main(String[] args) {
        //String s1 = "abc";
        String s1 = null;
        String s2 = "abc";

        //null是不能调用方法的，否则会抛出空指针异常NullPointerException
//        boolean b1 = s1.equals(s2);          //NullPointerException

        /*
         * 使用Objects类的equals方法：对两个对象进行比较，防止空指针异常
         * public static boolean equals(Object a, Object b) {
         *      return (a == b) || (a != null && a.equals(b));
         * }
         * */
        boolean b2 = Objects.equals(s1, s2);
        System.out.println(b2);                //false
    }
}
