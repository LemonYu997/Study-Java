package chapter04.heimaPro.demo03Calendar;

import java.util.Calendar;
import java.util.Date;

/*
 * 常用方法：
 *      1、public int get(int field)：返回给定日历字段的值
 *      2、public void set(int field, int value)：将给定的日历字段设置为给定值
 *      3、public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去给定的时间量
 *      4、public Date getTime()：返回一个表示Calendar时间值(从历元到现在的毫秒偏移量)的Date对象
 * 成员方法的参数：
 *      int field：日历类的字段，可以使用Calendar类的静态成员变量获取
 *
 *          public static final int YEAR = 1;                //年
 *          public static final int MONTH = 11;              //月
 *          public static final int DATE = 20;               //月中的某一天
 *          public static final int DAY_OF_MONTH = 5;        //月中的某一天
 *          public static final int HOUR = 10;               //时
 *          public static final int MINUTE = 50;             //分
 *          public static final int SECOND = 55;             //秒
 */
public class Demo01CalendarMethod {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
        demo04();
    }

    /*
     * public int get(int field)：返回给定日历字段的值
     * 参数：传递指定的日历字段(YEAR,MONTH,...)
     * 返回值：日历字段代表的具体的值
     * */
    private static void demo01() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        System.out.println(year);                   //2020

        //西方的月份0~11，东方1~12
        int month = c.get(Calendar.MONTH);
        System.out.println(month + 1);              //7

        //天数
        int date = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);                   //17

        System.out.println("---------------------");
    }

    /*
     * public void set(int field, int value)：将给定的日历字段设置为给定值
     * 参数：
     *      int field：传递指定的日历字段(YEAR,MONTH,...)
     *      int value：给指定字段设置的值
     * */
    private static void demo02() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();

        //设置年为9999
        c.set(Calendar.YEAR, 9999);
        //设置月为9月(从0计数，所以为8)
        c.set(Calendar.MONTH, 8);
        //设置天数为9日
        c.set(Calendar.DATE, 9);

        //同时设置年月日，使用set的重载方法
        c.set(8888, 8, 8);

        int year = c.get(Calendar.YEAR);
        System.out.println(year);                   //9999

        //西方的月份0~11，东方1~12
        int month = c.get(Calendar.MONTH);
        System.out.println(month + 1);              //9

        //天数
        int date = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);                   //9

        System.out.println("---------------------");
    }

    /*
     * public abstract void add(int field, int amount)：
     *      根据日历的规则，为给定的日历字段添加或减去给定的时间量
     * 参数：
     *      int field：传递指定的日历字段(YEAR,MONTH,...)
     *      int amount：增加减少指定的值
     *          正数：增加
     *          负数：减少
     * */
    private static void demo03() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();

        //把年增加两年
        c.add(Calendar.YEAR, 2);

        //把月份减少3个月
        c.add(Calendar.MONTH, -3);

        int year = c.get(Calendar.YEAR);
        System.out.println(year);                   //2022

        //西方的月份0~11，东方1~12
        int month = c.get(Calendar.MONTH);
        System.out.println(month + 1);              //4

        //天数
        int date = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);                   //17

        System.out.println("---------------------");
    }

    /*
     * public Date getTime()：返回一个表示Calendar时间值(从历元到现在的毫秒偏移量)的Date对象
     * 把日历对象转换为日期对象
     * */
    private static void demo04() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println(date);       //Fri Jul 17 23:06:21 CST 2020
    }
}
