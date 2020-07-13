//4.7 静态内部类
package chapter04.test07StaticInnerClass;

/* 静态内部类：
 * 有时候，使用内部类只是为了把一个类隐藏在另外一个类的内部，并不需要内部类引用外部类对象。
 * 这个时候，可以把内部类声明为static，以便取消产生的引用。
 *
 * 注释：
 * 1、在内部类不需要访问外部对象的时候，应该使用静态内部类。
 * 2、与常规内部类不同，静态内部类可以有静态域和方法。
 * 3、声明在接口中的内部类自动称为static和public类。
 * */

/**
 * 返回数组中的最大值和最小值。
 * @author mly
 * */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];

        //初始化数组为100个随机数
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }

        //引用静态内部类
        ArrayAlg.Pair p = ArrayAlg.minmax(d);

        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    //创建一个包含一对浮点数的类，静态内部类
    public static class Pair {
        private double first;
        private double second;

        /**
         * Pair类的构造器，初始化
         * @param f 第一个数
         * @param s 第二个数 */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * 返回Pair类中的第一个数
         * @return 第一个数
         * */
        public double getFirst() {
            return first;
        }

        /**
         * 返回Pair类中的第二个数
         * @return 第二个数
         * */
        public double getSecond() {
            return second;
        }
    }

    /**
     * 计算数组的最大值和最小值
     * @param values 一个浮点数数组
     * @return 返回一个Pair对象，包含两个元素，第一个元素是最小值，第二个是最大值。
     * */
    //静态内部类，用这种方式只用遍历一次数组
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;      //正无穷
        double max = Double.NEGATIVE_INFINITY;      //负无穷

        //遍历数组，更新最大值和最小值
        for (double v : values) {
            if (min > v)
                min = v;
            if (max < v)
                max = v;
        }

        return new Pair(min, max);
    }
}
