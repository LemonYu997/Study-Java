//主线程
package chapter11.heimaPro.demo01Thread;

/*
 * 主线程：执行主(main)方法的线程
 *
 * 单线程程序：java程序中只有一个线程，执行从main方法开始，从上到下依次执行
 *
 * JVM执行main方法，main方法会进入到栈内存
 * JVM会找操作系统开辟一条main方法通向CPU的执行路径
 * CPU就可以通过这个路径来执行main方法，而这个路径有一个名字，叫main(主)线程
 * */
//这是一个单线程程序，从上到下依次执行
public class Demo02MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("苍蓝星");
        p1.run();
        System.out.println(0/0);        //Exception in thread "main" java.lang.ArithmeticException: / by zero

        //单线程程序弊端，中间出现异常，后边程序无法执行
        Person p2 = new Person("咩咩子");
        p2.run();
    }
}
