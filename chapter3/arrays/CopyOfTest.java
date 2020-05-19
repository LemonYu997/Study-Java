//3.8 反射part3 利用反射编写泛型数组（即动态创建数组）
package chapter3.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        //增加数组，多出来的用0填充
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        //增加数组，多出来的用null填充
        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        //下面这个调用将生成一个异常
        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * 这个方法试图通过创建新数组和复制所有元素来增长数组
     * @param a 增长数组
     * @param newLength 新数组的长度
     * @return 一个更大的数组，包含原数组中的所有元素，但是返回类型是Object[]，和原数组a类型不同
     * */
    public static Object[] badCopyOf(Object[] a, int newLength)         //没用
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        /* 参数含义：
         * Object src : 原数组
         * int srcPos : 从元数据的起始位置开始
         * Object dest : 目标数组
         * int destPos : 目标数组的开始起始位置
         * int length  : 要copy的数组的长度            */
        return newArray;
    }

    /**
     * 这个方法可以新建一个同类型数组，并且复制所有元素
     * @param a 一个数组，可以是一个object数组或者基本类型数组
     * @return 返回一个更大的数组，包含a中所有元素
     * */
    public static Object goodCopyOf(Object a, int newLength)
    {
        Class cl = a.getClass();
        //判断a的类型是否为数组，否则返回null
        if (!cl.isArray())
            return null;
        Class componentType = cl.getComponentType();        //返回表示数组类型的Class
        int length = Array.getLength(a);                    //返回长度

        //创建一个新数组，类型与原数组相同，长度重新设置
        Object newArray = Array.newInstance(componentType, newLength);

        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
