//Calendar类，获取对象的方式
package chapter04.heimaPro.demo03Calendar;

/*
 * java.util.Calendar类：日历类
 *
 * Calendar类是一个抽象类，里边提供了许多操作日历字段的方法(YEAR、MONTH、DAY_OF_MONTH、HOUR)
 * Calendar类是无法直接创建对象使用，里边有一个静态方法叫getInstance()，该方法返回了Calendar类的子类对象
 * */

import java.util.Calendar;

public class Demo01Calendar {
    public static void main(String[] args) {
        //使用父类方法得到子类对象
        Calendar c = Calendar.getInstance();    //多态
        System.out.println(c);                  //重写了toString方法
    }
}
