//字符串常量池
package chapter02.heima.demo05String;

/*
 * 字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池当中
 *
 * 注意事项：
 * 1、对于基本类型来说，==是进行数值的比较
 * 2、对于引用类型来说，==是进行【地址值】的比较
 * 3、双引号直接写的字符串在常量池当中，new的不在池当中
 * */

public class Demo02StringPool {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] chars = {'a', 'b', 'c'};
        String str3 = new String(chars);

        System.out.println(str1 == str2);       //true，地址相等
        System.out.println(str2 == str3);       //false，地址不相等
        System.out.println(str1 == str3);       //false，地址不相等
    }
}
