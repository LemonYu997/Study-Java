//System类的常用方法
package chapter04.heimaPro.demo04System;

import java.util.Arrays;

/*
 * java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作
 * 在System类的API文档中，常用的方法有：
 *      public static long currentTimeMillis()：返回以毫秒为单位的当前时间
 *      public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：
 *      将数组中指定的数据拷贝到另一个数组中
 * */
public class Demo01System {
    public static void main(String[] args) {
        demo01();
        demo02();
    }

    /*
     * public static long currentTimeMillis()：返回以毫秒为单位的当前时间
     * 用来测试程序的效率
     * 验证for循环打印数字1~9999所需要使用的时间(毫秒)
     * */
    private static void demo01() {
        //程序执行前，获取一次毫秒值
        long start = System.currentTimeMillis();
        //执行一个for循环
        for (int i = 1; i < 9999; i++) {
            System.out.println(i);
        }
        //程序执行后，再次获得一次毫秒值
        long end = System.currentTimeMillis();
        System.out.println("程序耗时：" + (end - start) + "毫秒");
    }

    /*
     * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     * 将数组中指定的数据拷贝到另一个数组中
     * 参数：
     *      src - 源数组
     *      srcPos - 源数组中的起始位置(起始的索引)
     *      dest - 目标数组
     *      destPos - 目标数据中的起始位置
     *      length - 要复制的数组元素的数量
     * 练习：
     *      将src数组中前3个元素，复制到dest数组的前3个位置上
     *      复制元素前：
     *          src数组为：[1, 2, 3, 4, 5]
     *          dest数组为：[6, 7, 8, 9, 10]
     *      复制元素后：
     *          src数组为：[1, 2, 3, 4, 5]
     *          dest数组为：[1, 2, 3, 9, 10]
     * */
    private static void demo02() {
        //定义源数组
        int[] src = {1, 2, 3, 4, 5};
        //定义目标数组
        int[] dest = {6, 7, 8, 9, 10};
        System.out.println("复制前：" + Arrays.toString(dest));
        //使用System类中的arraycopy方法把源数组的前3个元素复制到目标数组的前3个位置上
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println("复制后：" + Arrays.toString(dest));
    }
}
