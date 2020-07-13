//1.7 数组和for each循环
package chapter01;

import java.util.Arrays;

public class Test07arrayForEach {
    public static void main(String[] args) {
        //声明数组，可以用 int[] a 方式声明，也可以用int a[]声明，用第一种方法可以将类型和变量名分开
        int[] a = new int[10];
        //创建数组时，默认每个元素初始化为0

        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }

        //使用for each循环处理数组中的每个元素
        //打印数组的每个元素，每个元素占一行
        for (int element: a) {
            System.out.println(element);
        }

        //使用length方法可以获得数组长度
        int length = a.length;

        //使用普通for循环打印数组
        for (int i = 0; i < length; i++) {
            System.out.println(a[i]);
        }

        //利用Arrays类中的toString方法，返回一个包含数组元素的字符串
        System.out.println(Arrays.toString(a));

        //初始化数组的一种方式，这种方式不需要用new
        int[] smallPrimes = {2, 3, 5, 7, 11, 13};

        //不创建新变量的情况下重新初始化一个数组
        smallPrimes = new int[] {17, 19, 23, 29, 31, 37};

        //上个初始化方式的简写
        int[] anonymous = {17, 19, 23, 29, 31, 37};
        smallPrimes = anonymous;

        //数组拷贝，将一个数组变量拷贝给另一个数组变量
        int[] luckyNumbers = smallPrimes;
        luckyNumbers[5] = 12;

        //使用copyOf方法，将一个数组的所有值拷贝到一个新数组中
        int[] copiedLuckyNumbers = Arrays.copyOf(luckyNumbers, 2 * luckyNumbers.length);
        //第2个参数是新数组的长度
        //如果数组是数值型，多余的元素将被赋值为0，布尔型则为false，长度小于原始数组长度时，只拷贝前面的数据元素

        //命令行参数数组
        if (args.length == 0 || args[0].equals("-h"))
            System.out.print("Hello,");
        else if (args[0].equals("-g"))
            System.out.print("Goodbye,");
        //打印其他命令行参数
        for (int i = 1; i < args.length; i++)
            System.out.print(" " + args[i]);
        System.out.println("!");

        /*如果在命令行中用以下形式运行该程序
        * java arrayForEach -g cruel world
        * args[]数组中包含下列内容：
        * args[0]: "-g"
        * args[1]: "cruel"
        * args[2]: "world"
        * 程序将显示以下内容：
        * Goodbye, cruel world!
        *
        * 注释： java中的程序名并没有存储在args数组中，用下列命令运行时
        * java arrayForEach -h world
        * args[0]是 "-h" 而不是 "arrayForEach"
        * */
    }
}
