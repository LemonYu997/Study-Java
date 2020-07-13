//2.1 对象的示例
package chapter02;

import java.util.Date;

public class Test01ObjectTest {
    public static void main(String[] args) {
        //构造一个对象，并将其放入一个变量中
        Date birthday = new Date();
        //表达式new Date()构造了一个Date类型的对象，它的值是对新创建对象的引用，这个引用存储在变量birthday中

        //对象与对象变量的区别
        Date deadline;
        /*注释：
        * 上述语句定义了一个对象变量deadline，它可以引用Date类型的对象。但是要认识到：
        * deadline不是一个对象，实际上也没有引用对象。不能将任何Date方法应用于这个变量上。
        * 要先初始化变量deadline，有两个选择：
        * */
        deadline = new Date();              //用新构造的对象初始化这个变量
        deadline = birthday;                //让该变量引用一个已存在的对象
        //总结：一个对象变量并没有实际包含一个对象，而仅仅引用一个对象


        System.out.println();
    }
}
