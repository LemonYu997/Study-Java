package chapter14.heimaPro.demo03Function;

import java.util.function.Predicate;

/*
 * 逻辑表达式：可以连接多个判断的条件
 * &&：与运算符，有false则false
 * ||：或运算符，有true则true
 * ！：非(取反运算符)，非true则false，非false则true
 *
 * 需求：判断一个字符串，有两个判断的条件
 * 1、判断字符串的长度是否大于5
 * 2、判断字符串中是否包含a
 *
 * 两个条件必须同时满足，就可以使用&&运算符连接两个条件
 *
 * Predicate接口中的默认方法and，表示并且关系，也可以用于连接两个判断条件
 * default Predicate<T> and(Predicate<? super T> other) {
 *       Objects.requireNonNull(other);
 *       return (t) -> test(t) && other.test(t);
 *  }
 *
 * 方法内部的两个判断条件，也是使用&&运算符连接起来
 * */
public class Demo07PredicateAnd {
    /*
     * 定义一个方法，方法的参数，传递一个字符串
     * 传递两个Predicate接口：
     *      1、判断字符串的长度是否大于5
     *      2、判断字符串中是否包含a
     * 两个条件必须同时满足
     * */
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
//        return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);      //等价于上边那行代码
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "abcde";
        //调用checkString方法，参数传递字符串和两个Lambda表达式
        boolean b = checkString(s, (String str) -> {
            //判断字符串的长度是否大于5
            return str.length() > 5;
        }, (String str) -> {
            //判断字符串中是否包含a
            return str.contains("a");
        });
        System.out.println(b);
    }

}
