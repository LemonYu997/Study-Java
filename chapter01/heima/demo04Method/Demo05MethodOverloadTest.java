//方法重载练习题
package chapter01.heima.demo04Method;

public class Demo05MethodOverloadTest {
    public static void main(String[] args) {
        //题一测试
        byte a = 10;
        byte b = 20;
        System.out.println(isSame(a, b));
        System.out.println(isSame((short)a, (short)b));
        System.out.println(isSame(10, 20));
        System.out.println(isSame(10L, 20L));
        System.out.println("----------------------------------");

        //题二测试
        myPrint(100);
        myPrint("Hello");
        myPrint('a');
    }

    /* 题一：
     * 题目要求：比较两个数据是否相等。
     * 参数类型分别为两个byte类型，两个short类型，两个int类型，两个long类型。
     * 并在main方法中进行测试。
     * */
    public static boolean isSame(byte a, byte b) {
        System.out.println("两个byte类型参数执行！");
        return a == b;
    }

    public static boolean isSame(short a, short b) {
        System.out.println("两个short类型参数执行！");
        return a == b;
    }

    public static boolean isSame(int a, int b) {
        System.out.println("两个int类型参数执行！");
        return a == b;
    }

    public static boolean isSame(long a, long b) {
        System.out.println("两个long类型参数执行！");
        return a == b;
    }

    /* 题二：
     * 打印输出所有类型
     * byte short int long float double char boolean
     * String
     * */
    public static void myPrint(byte num) {
        System.out.println(num);
    }

    public static void myPrint(short num) {
        System.out.println(num);
    }

    public static void myPrint(int num) {
        System.out.println(num);
    }

    public static void myPrint(long num) {
        System.out.println(num);
    }

    public static void myPrint(float num) {
        System.out.println(num);
    }

    public static void myPrint(double num) {
        System.out.println(num);
    }

    //按住shift + F6，可以同时更改方法中所有同名参数名
    public static void myPrint(boolean is) {
        System.out.println(is);
    }

    public static void myPrint(char zifu) {
        System.out.println(zifu);
    }

    public static void myPrint(String str) {
        System.out.println(str);
    }
}
