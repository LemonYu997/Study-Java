//方法练习题
package chapter01.heima.demo04Method;


public class Demo03MethodTest {
    public static void main(String[] args) {
        //题一测试
        System.out.println(isSame(10, 20));         //false
        System.out.println(isSame(10, 10));         //true
        System.out.println("------------------------------");

        //题二测试
        System.out.println("结果是: " + getSum());
        System.out.println("------------------------------");

        //题三测试
        printCount(5);
    }

    /* 题一：
     * 题目要求：定义一个方法，用来判断两个数字是否相同。
     * 三要素：
     * 返回值类型：boolean
     * 方法名称：isSame
     * 参数列表：int a, int b
     * */
    public static boolean isSame(int a, int b) {
        /*boolean same;

        if (a == b) {
            same = true;
        } else {
            same = false;
        }*/

//        same = a == b ? true : false;

//        boolean same = (a == b);

        return a == b;
    }

    /* 题二：
     * 题目要求：用来求出1~100之间所有数字的和值
     * 三要素：
     * 返回值：有返回值，int
     * 方法名称：getSum
     * 参数列表：数据范围已经确定，是固定的，所以不需要告诉我任何条件，不需要参数
     * */
    public static int getSum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    /* 题二：
     * 题目要求：用来打印指定次数的Hello World
     * 三要素：
     * 返回值：只进行打印操作，无返回值
     * 方法名称：printCount
     * 参数列表：打印的次数，int
     * */
    public static void printCount(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("Hello World!" + (i + 1));
        }
    }
}
