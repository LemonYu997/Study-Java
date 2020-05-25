//4.4 lambda表达式学习
package chapter4.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * 在一个比较器和一个动作监听器中使用lambda表达式
 * @author mly
 * */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

        System.out.println(Arrays.toString(planets));       //打印字符串数组
        System.out.println("Sorted in dictionary order: ");
        Arrays.sort(planets);                               //按字典顺序（即首字母）进行排序
        System.out.println(Arrays.toString(planets));       //打印排序后的字符串数组

        System.out.println("Sorted by length: ");
        //使用lambda表达式，按长度进行排序
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));       //打印排序后的字符串数组

        /* 函数式接口：
         * Arrays.sort()方法的第二个参数需要一个Comparator实例，而Comparator是只有一个方法的接口。
         * 对于只有一个抽象方法的接口，需要这种接口的对象时，可以提供一个lambda表达式。
         * 这种接口称为函数式接口。
         *
         * lambda更像一个函数，而不是一个对象。        */


        //使用lambda表达式
        Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        t.start();

        //用户确认是否退出
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
