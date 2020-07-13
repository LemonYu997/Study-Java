//数组的常用方法
package chapter01.heima.Demo05Array;

/*
 * 一、获取数组长度
 * 如何获得数组长度，格式：
 * 数组名称.length
 *
 * 这将会得到一个int数组，代表数组的长度
 * 注意：数组一旦创建，程序运行期间，长度不可改变。
 *
 * 二、遍历数组
 * 使用循环，次数就是数组的长度
 * IDEA中键入array.fori即可自动生成代码
 *
 * 三、求数组中的最值
 * 最大值和最小值
 *
 * 四、数组反转
 * 本来的样子：[1, 2, 3, 4]
 * 之后的样子: [4, 3, 2, 1]
 * 要求：不能使用新数组，就用原来的唯一一个数组
 * 1.数组元素反转，其实就是对称位置的元素交换
 * 2.通常遍历数组用的是一个索引
 *      int i = 0;
 * 现在表示对称位置需要两个索引
 *      int min = 0;
 *      int max = array.length - 1;
 * 3.如何交换两个变量的值
 *      int temp = a;
 *      a = b;
 *      b = temp;
 * 4.什么时候停止交换？
 *      (1)min == max
 *      (2)min > max
 * 什么时候应该交换？
 *      min < max
 * */

public class Demo04ArrayMethod {
    public static void main(String[] args) {
        length();
        printAll();
        max();
        min();
        reverse();
    }

    //一、获取数组的长度
    public static void length() {
        System.out.println("一、获取数组长度");
        int[] arrayA = new int[3];
        int[] arrayB = {1, 5, 6, 8, 7, 9, 10, 32, 55, 10};
        int len = arrayB.length;
        System.out.println("arrayB数组的长度是： " + len);

        int[] arrayC = new int[3];
        System.out.println(arrayC.length);  //3
        arrayC = new int[5];        //创建了一个新数组，地址不同，旧数组长度未变
        System.out.println(arrayC.length);  //5
        System.out.println("--------------------------------");
    }

    //二、遍历数组
    public static void printAll() {
        System.out.println("二、遍历数组");
        int[] array = {15, 25, 30, 40, 50};
        //使用循环，次数就是数组的长度
        //IDEA中键入array.fori即可自动生成代码
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("--------------------------------");
    }

    //三、求数组中的最值
    public static void max() {
        System.out.println("三、求数组中的最值");
        int[] array = {5, 15, 25, 30, 20, 10000};
        //从0开始
        int max = array[0];
        //依次和数组中的每个元素比较
        for (int i = 1; i < array.length; i++) {
            //如果当前元素，比max更大，更新max
            if (array[i] > max) {
                max = array[i];
            }
        }
        //最后留下的就是max
        System.out.println("最大值：" + max);
    }

    public static void min() {
        int[] array = {5, 15, 25, 30, -20, 10000};
        //从0开始
        int min = array[0];
        //依次和数组中的每个元素比较
        for (int i = 1; i < array.length; i++) {
            //如果当前元素，比min更小，更新min
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("最小值：" + min);
        System.out.println("--------------------------------");
    }

    //四、数组反转
    public static void reverse() {
        System.out.println("四、数组反转");
        int[] array = {10, 20, 30, 40, 50, 60};
        //遍历打印数组本来的样子
        System.out.println("原先的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        /* 反转
         * 初始化语句：int min = 0, max = array.length - 1;
         * 条件判断：min < max
         * 步进表达式：min++, max--
         * 循环体：用第三个变量倒手
         * */
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }

        //遍历打印数组反转后的样子
        System.out.println("反转后的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------");
    }
}
