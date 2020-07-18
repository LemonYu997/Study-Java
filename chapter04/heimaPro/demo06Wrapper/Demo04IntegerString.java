//基本类型与字符串类型之间的相互转换
package chapter04.heimaPro.demo06Wrapper;

/*
 * 基本类型与字符串类型之间的相互转换
 * 基本类型->字符串(String)
 *      1、基本类型的值 + "" 最简单的方法(工作中常用)
 *      2、包装类的静态方法toString(参数)，不是Object类的toString()重载
 *          static String toString(int i) 返回一个表示指定整数的 String 对象
 *      3、String类的静态方法valueOf(参数)
 * 字符串(String)->基本类型
 *      使用包装类的静态方法parseXXX("字符串);
 *          Integer类：static int parseInt(String s)
 *          Double类：static double parseDouble(String s)
 * */

public class Demo04IntegerString {
    public static void main(String[] args) {
        //基本类型->字符串(String)
        //1、基本类型的值 + ""
        int i1 = 100;
        String s1 = i1 + "";
        System.out.println(s1 + 200);       //100200    字符串

        //2、包装类的静态方法toString(参数)
        String s2 = Integer.toString(100);
        System.out.println(s2 + 200);       //100200    字符串

        //3、String类的静态方法valueOf(参数)
        String s3 = String.valueOf(100);
        System.out.println(s3 + 200);       //100200    字符串
        System.out.println("-----------------------");

        //字符串(String)->基本类型
        int i = Integer.parseInt(s1);
        System.out.println(i - 10);         //90        int

        //不按规矩来，会抛出异常
//        int a = Integer.parseInt("a");
//        System.out.println(a);              //NumberFormatException异常
    }
}
