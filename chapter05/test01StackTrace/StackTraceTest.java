//5.1 异常 分析堆栈轨迹元素
package chapter05.test01StackTrace;

/* 堆栈轨迹(stack trace)：
 * 一个方法调用过程的列表，包含了程序执行过程中方法调用的特定位置。*/

import java.util.Scanner;

/**
 * 打印递归阶乘函数的堆栈情况
 * @version 1.01 2.20-05-29
 * @author mly
 * */
public class StackTraceTest {
    /**
     * 计算一个数的阶乘
     * @param n 一个非负整数
     * @return n! = 1*2*3*...n
     * */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");

        //输出堆栈情况
        Throwable t = new Throwable();
        //getStackTrace方法，获得构造这个对象时调用堆栈的跟踪
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames)
            System.out.println(f);

        //递归计算阶乘
        int r;
        if (n <= 1)
            r = 1;
        else
            r = n * factorial(n - 1);

        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        factorial(n);
    }
}

