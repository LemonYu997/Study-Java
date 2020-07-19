//可变参数
package chapter07.heimaPro.demo05VarArgs;

/*
 * 可变参数：JDK1.5+之后出现的新特性
 * 使用前提：
 *      当方法的参数列表数据类型已经确定，但是参数的个数不确定，就可以使用可变参数
 *
 * 使用格式：定义方法时使用
 *      修饰符 返回值类型 方法名(数据类型...变量名){}
 *
 * 可变参数的原理：
 *      可变参数底层就是一个数组，根据传递参数个数不同，会创建不同长度的数组，来存储这些参数
 *      传递的参数个数，可以是0个(不传递),    1 , 2...多个
 *
 * 注意事项：
 *      1、一个方法的参数列表，只能有一个可变参数
 *      2、如果方法的参数有多个，那么可变参数必须写在参数列表的末尾
 *
 * 可变参数的特殊写法(终极写法)
 * public static void method(Object...obj) {}
 *
 * */
public class Demo01VarArgs {
    public static void main(String[] args) {
        int i1 = add(10, 20, 30, 40, 50, 60);
        System.out.println(i1);      //210
        int i2 = add(5, 9, 134, 5659, 1111);
        System.out.println(i2);      //6918
        int i3 = add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(i3);      //55

        //如果方法的参数有多个，那么可变参数必须写在参数列表的末尾
        method1("aaa", 5, 1, 2, 3, 4, 5);
    }

    //定义一个方法，计算两个int类型整数的和
    public static int add(int a, int b) {
        return a + b;
    }

    //定义一个方法，计算三个int类型整数的和
    //重载
    public static int add(int a, int b, int c) {
        return a + b;
    }

    /*
     * 定义计算(0~n)整数和的方法
     * 已知：计算整数的和，数据类型已经确定int
     * 但是参数的个数不确定，不知道要计算几个整数的和，可以使用可变参数
     * add(); 创建一个长度为0的数组 new int[0]
     * add(1); 创建一个长度为1的数组 new int[1]
     * */
    public static int add(int ... arr) {
//        System.out.println(arr);            //[I@1b6d3586 数组的地址，底层是一个数组
//        System.out.println(arr.length);     //数组的长度 参数为空时，创建一个长度为0的数组

        //定义一个初始化的变量，记录累加求和
        int sum = 0;
        //遍历数组，获取数组中的每一个元素
        for (int i : arr) {
            //累加求和
            sum += i;
        }

        //返回结果
        return sum;
    }

    //一个方法的参数列表，只能有一个可变参数
//    public static void method(int ... a, String ... s) {}       //报错

    //如果方法的参数有多个，那么可变参数必须写在参数列表的末尾
//    public static void method(int ... a, String s, int z) {}      //报错
    public static void method1(String s, int z, int ... a) {}        //可以运行

    //可变参数的特殊写法(终极写法)
    public static void method2(Object...obj) {}
}
