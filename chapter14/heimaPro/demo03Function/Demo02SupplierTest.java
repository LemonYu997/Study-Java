//Supplier接口练习
package chapter14.heimaPro.demo03Function;

import java.util.function.Supplier;

/*
 * 使用Supplier接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值
 * 提示：
 * 接口的泛型使用java.lang.Integer类
 * */
public class Demo02SupplierTest {
    //定一个方法，用于获取int类型数组中元素的最大值，方法的参数传递Supplier接口，泛型使用Integer
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        //定义一个int类型的数组并赋值
        int[] arr = {1, 99, 226, 4685, 22, 464, 41};
        //调用getMax方法，方法的参数Supplier是一个函数式接口，所以可以传递Lambda表达式

        int maxValue = getMax(() -> {
            //获取数组的最大值并返回
            //定义一个变量，把数组中的第一个元素赋值给该变量，记录数组中元素的最大值
            int max = arr[0];
            //遍历数组，获取数组中的其他元素
            for (int i : arr) {
                //使用其他元素和最大值比较
                if (i > max) {
                    max = i;        //最大值替换
                }
            }
            //返回最大值
            return max;
        });

        System.out.println("数组中元素的最大值是：" + maxValue);
    }
}
