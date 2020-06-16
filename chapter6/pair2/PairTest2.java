//6.2 类型变量的限定
package chapter6.pair2;

/* 说明：
 * 有时候需要对泛型类的类型变量进行限定，格式如下：
 * <T extends BoundingType>
 * T表示绑定类型的子类型。T和绑定类型可以是类，也可以是接口。
 * */

import java.time.LocalDate;

/**
 * @version 1.0
 * @author mly
 * */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),  //G.Hopper
                LocalDate.of(1815, 12, 10), //A.Lovelace
                LocalDate.of(1903, 12, 3),  //J.von Neumann
                LocalDate.of(1910, 6, 22),  //K.Zuse
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg {
    /**
     * 得到类型为T的数组的最大值和最小值
     * @param a 一个T类型数组
     * @return 一个Pair类，包含最大值和最小值，或者返回null，如果数组为空或不存在
     * */
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        /* 说明：
         * 1、使用泛型方法时，<>的内容放在返回类型前
         * 2、由于不是所有类都有compareTo方法，这里绑定了Comparable接口
         * 3、现在的泛型方法只能被实现了Comparable接口的类的数组调用       */
        if (a == null || a.length == 0)
            return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0)
                min = a[i];
            if (max.compareTo(a[i]) < 0)
                max = a[i];
        }
        return new Pair<>(min, max);
    }
}

//泛型类
class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}