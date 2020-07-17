//DateFormat类 和 SimpleDateFormat
package chapter04.heimaPro.demo02Date;

/*
 * DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。
 * 日期/时间格式化子类（如 SimpleDateFormat）允许进行格式化（也就是日期 -> 文本）、解析（文本-> 日期）和标准化
 *
 * java.text.DateFormat：是日期/时间格式化子类的抽象类
 * 作用：
 *      格式化（也就是日期 -> 文本）、解析（文本-> 日期）
 * 成员方法：
 *      String format(Date date)：按照指定的模式，把Date日期，格式化为符合模式的字符串
 *      Date parse(String source)：把符合模式的字符串，解析为Date日期
 * DateFormat是抽象类，无法直接创建对象引用，可以使用DateFormat的子类
 *
 * java.text.SimpleDateFormat extends DateFormat
 * 构造方法：
 *      SimpleDateFormat(String pattern)
 *          用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
 *      参数：
 *          String pattern
 *      模式：区分大小写的
 *          y   年
 *          M   月
 *          d   日
 *          H   时
 *          m   分
 *          s   秒
 *      写对应的模式，会把模式替换为对应的日期和时间
 *          "yyyy-MM-dd HH:mm:ss"
 *      注意：
 *          模式中的字母不能更改，连接模式的符号可以改变
 *          "yyyy年MM月dd日 HH时mm分ss秒"
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo03DateFormat {
    public static void main(String[] args) throws ParseException {
        demo01();
        demo02();
    }

    /*
     * 使用DateFormat类中的方法format，把日期格式化为文本
     * 使用步骤：
     *      1、创建一个SimpleDateFormat对象，构造方法中传递指定的模式
     *      2、调用SimpleDateFormat对象中的方法format，
     *         按照构造方法中指定的模式，把Date日期格式化为符合模式的字符串(文本)
     * */
    private static void demo01() {
        //1、创建SimpleDateFormat对象，构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //2、调用SimpleDateFormat对象中的方法format，按照构造方法中指定的模式，把Date日期格式化为符合模式的字符串(文本)
        //String format(Date date)：按照指定的模式，把Date日期，格式化为符合模式的字符串
        Date date = new Date();
        String d = sdf.format(date);
        //原始的date
        System.out.println(date);       //Fri Jul 17 22:08:04 CST 2020
        //格式化后的字符串
        System.out.println(d);          //2020年07月17日 22时08分04秒
        System.out.println("----------------------------");
    }

    /*
     * 使用DateFormat类中的方法parse，把文本解析为日期
     * 使用步骤：
     *      1、创建一个SimpleDateFormat对象，构造方法中传递指定的模式
     *      2、调用SimpleDateFormat对象中的方法parse，把符合构造方法中的字符串，解析为Date日期
     * 注意：
     *      public Date parse(String source) throws ParseException
     *      parse方法声明了一个异常叫ParseException
     *      如果字符串和构造方法的模式不一样，那么程序就会抛出此异常
     *      调用一个抛出了异常的方法，就必须处理这个异常，要么throws继续抛出这个异常，要么try catch自己处理
     * */
    private static void demo02() throws ParseException {
        //1、创建SimpleDateFormat对象，构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //2、调用SimpleDateFormat对象中的方法parse，把符合构造方法中的字符串，解析为Date日期
        //Date parse(String source)：把符合模式的字符串，解析为Date日期
        Date date = sdf.parse("2020年07月17日 22时08分04秒");
        System.out.println(date);       //Fri Jul 17 22:08:04 CST 2020
    }
}
