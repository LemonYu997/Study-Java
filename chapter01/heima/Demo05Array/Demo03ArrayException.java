//数组的常见异常
package chapter01.heima.Demo05Array;

/*
 * 数组的索引编号从0开始，一直到"数组的长度 - 1"为止
 *
 * 一、数组索引越界异常
 * 如果访问数组元素的时候，索引编号并不存在，那么会发生数组索引越界异常
 * ArrayIndexOutOfBoundsException
 * 原因：索引编号写错了
 * 解决办法：修改称为存在的正确的索引编号
 *
 * 二、空指针异常
 * 所有的引用类型变量，都可以赋值为一个null，表示其中什么都没有
 * 数组必须进行new初始化才能使用其中的元素，如果只是赋值一个null，没有进行new创建，
 * 将会发生 NullPointerException 空指针异常
 *
 * 原因：忘了 new
 * 解决办法：补上 new
 * */

public class Demo03ArrayException {
    public static void main(String[] args) {
        //数组索引越界异常
        int[] array1 = {15, 25, 35};
        System.out.println(array1[0]);  //15
        System.out.println(array1[1]);  //25
        System.out.println(array1[2]);  //35
        //错误写法：并不存在3号元素，所以发生数组越界异常
//        System.out.println(array1[3]);  //异常
        System.out.println("------------------------");

        //空指针异常
        int[] array2 = null;
//        array2 = new int[3];
        System.out.println(array2[0]);

    }
}
