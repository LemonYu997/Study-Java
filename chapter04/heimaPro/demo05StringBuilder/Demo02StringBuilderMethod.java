//StringBuilder的常用方法
package chapter04.heimaPro.demo05StringBuilder;

/*
 * StringBuilder的常用方法：
 *      public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身
 * */
public class Demo02StringBuilderMethod {
    public static void main(String[] args) {
        //创建StringBuilder对象
        StringBuilder bu = new StringBuilder();
        //使用append方法往StringBuilder对象中添加数据
        //append方法返回的是this，调用方法的对象bu，this == bu
        StringBuilder bu2 = bu.append("abc");   //把bu的地址赋值给了bu2
        System.out.println(bu);     //abc
        System.out.println(bu2);    //abc
        //比较的是地址
        System.out.println(bu == bu2);      //true

        //使用append方法无需要接收返回值
        bu.append("Jack");
        bu.append(13);
        bu.append('牛');
        System.out.println(bu);     //abcJack13牛

        /*
         * 链式变成：方法返回值是一个对象，可以继续调用方法
         * */
        bu.append("abc").append(2).append("Jack").append('牛');
        System.out.println(bu);     //abcJack13牛abc2Jack牛
    }
}
