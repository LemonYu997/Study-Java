//练习：自定义函数模型拼接
package chapter14.heimaPro.demo03Function;

import java.util.function.Function;

/*
 * 使用Function进行函数模型的拼接，按照顺序执行的多个函数操作：
 * String str = "苍蓝星,20";
 *
 * 分析：
 * 1、将字符串截取数字年龄部分，得到字符串
 *    Function<String, String> "苍蓝星,20"->"20"
 * 2、将上一步的字符串转换为int类型的数字
 *    Function<String, Integer> "20"->20
 * 3、将上一步的int数字累加100，得到结果int数字
 *    Function<Integer, Integer> 20->120
 * */
public class Demo13FunctionTest {
    /*
     * 定义一个方法
     * 参数传递包含姓名和年龄的字符串
     * 参数再传递3个Function接口用于类型转换
     * */
    public static int change(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        //使用andThen方法把三个转换组合到一起
        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String str = "苍蓝星,20";
        //调用change方法，参数传递字符串和3个Lambda表达式
        int num = change(str, (String s) -> {
            //"苍蓝星,20"->"20"
            return s.split(",")[1];
        }, (String s) -> {
            //"20"->20
            return Integer.parseInt(s);
        }, (Integer i) -> {
            //20-120
            return i + 100;
        });

        System.out.println(num);
    }
}
