//3.9 反射part4 利用反射调用任意方法
package chapter03.test09Methods;

import java.lang.reflect.Method;

/**利用反射调用任意方法
 * @author mly
 * */
public class MethodTableTest {
    public static void main(String[] args) throws Exception {
        //获取指向square和sqrt的方法指针
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        //用表格输出x和y的值
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * 返回一个数的平方
     * @param x 一个数
     * @return x的平方
     * */
    public static double square(double x)
    {
        return x * x;
    }

    /**
     * 输出关于x和y的值的表
     * @param from x值得下界
     * @param to x值得上界
     * @param n 表得行数
     * @param f 要调用的方法，参数类型和返回类型都是double
     * */
    public static void printTable(double from, double to, int n, Method f)
    {
        //输出表头
        System.out.println(f);
        double dx = (to - from) / (n - 1);              //一行的元素数

        for (double x = from; x <= to ; x+= dx) {
            try {
                double y = (Double) f.invoke(null, x);
                /*invoke()注释：
                * 调用这个对象所描述的方法，传递给定参数，并返回方法的返回值。
                * 对于静态方法，把null作为隐式参数传递。在使用包装器传递基本类型的值时，
                * 基本类型的返回值必须是未包装的*/
                System.out.printf("%10.4f | %10.4f%n", x, y);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
