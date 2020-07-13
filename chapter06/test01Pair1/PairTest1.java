//6.1 泛型类
package chapter06.test01Pair1;

/* 说明：
 * 一个泛型类(generic class)就是具有一个或多个类型变量的类  */

/**
 * @version 1.0
 * @author mly
 * */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg {
    /**
     * 以字符串的形式得到数组的最大值和最小值
     * @param a 一个字符串数组
     * @return 一个Pair类，包含最大值和最小值，或者返回null，如果数组为空或不存在
     * */
    public static Pair<String> minmax(String[] a) {         //用具体的类型替换类型变量就可以实例化泛型类型
        if (a == null || a.length == 0)
            return null;
        String min = a[0];
        String max = a[0];
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
    /* 说明：
     * 这里的 T 即类型变量，表示任意类型
     * */
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