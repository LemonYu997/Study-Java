//6.3 通配符
package chapter6.pair3;

/* 说明：
 * 通配符使用时，允许类型参数变化。例如：
 * Pair<? extends Employee>，允许子类调用该方法
 * */

import chapter3.equals.Employee;
import chapter3.equals.Manager;

/**
 * @version 1.0
 * @author mly
 * */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();
        minmaxSalary(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
        maxminSalary(managers, result);
        System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
    }

    //标识任何泛型Pair类型，它的类型参数是Employee的子类，如Pair<Manager>
    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    /* 通配符的超类型限定，这里限制为Manager的所有超类型。
     * 带有超类型限定的通配符可以向泛型对象写入，带有子类型限定的通配符可以从泛型对象读取
     * */
    public static void minmaxSalary(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0)
            return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getSalary() > a[i].getSalary())
                min = a[i];
            if (max.getSalary() < a[i].getSalary())
                max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    //交换 大小值 的显示顺序
    public static void maxminSalary(Manager[] a, Pair<? super Manager> result) {
        minmaxSalary(a, result);
        //swapHelper方法捕获通配符类型
        PairAlg.swapHelper(result);
    }
}

class PairAlg {
    /* 无限定通配符<?>，在这里类似为：
     * public static <T> boolean hasNulls(Pair<T> p)
     * */
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    /* 通配符不是类型变量，因此如下代码不合法：
     * ? t = p.getFirst();      //Error
     * */
    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    //swapHelper是一个泛型方法，而swap不是，它具有固定的Pair<?>类型的参数
    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
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