//Date类的构造方法和成员方法
package chapter04.heimaPro.demo02Date;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }

    /*
    * Date类的空参数构造方法
    * Date()获取当前系统的日期和时间
    * */
    private static void demo01() {
        Date date = new Date();             //util包
        //打印当前的系统时间，说明Date类重写了toString方法
        System.out.println(date);           //Fri Jul 17 20:55:10 CST 2020
        System.out.println("--------------------------------");
    }

    /*
     * Date类的带参数构造方法
     * Date(long date)：传递毫秒值，把毫秒值转换为Date日期
     * */
    private static void demo02() {
        Date date1 = new Date(0L);
        //时间原点 东八区
        System.out.println(date1);   //Thu Jan 01 08:00:00 CST 1970

        //计算后的时间
        Date date2 = new Date(1594976351833L);
        System.out.println(date2);   //Fri Jul 17 16:59:11 CST 2020
        System.out.println("--------------------------------");
    }

    /*
     * 成员方法
     * long getTime()       //把日期转换为毫秒
     * 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
     * */
    private static void demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);       //1594991194848L
    }
}
