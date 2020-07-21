package chapter11.heimaPro.demo10Lambda;

import chapter11.heimaPro.demo10Lambda.test1.Cook;
import chapter11.heimaPro.demo10Lambda.test2.Person;
import chapter11.heimaPro.demo10Lambda.test3.Calculator;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * lambda表达式：是可推导，可省略的
 * 凡是根据上下文推导出来的内容，都可以省略书写
 * 可以省略的内容：
 *      1、(参数列表)：括号中参数列表的数据类型，可以省略不写
 *      2、(参数列表)：括号中的参数如果只有一个，那么类型和()都可以省略
 *      3、{一些代码}：如果{}中的代码只有一行，无论是否有返回值，都可以省略{}，return，分号
 *         注意：要省略，{}，return，分号 三样必须同时省略
 *
 * lambda的使用前提：
 * 1、使用lambda必须具有接口，且要求接口中有且仅有一个抽象方法
 *    无论是JDK内置的Runnable、Comparator接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用lambda
 * 2、使用lambda必须具有上下文推断
 *    也就是方法的参数或局部变量类型必须为lambda对象的接口类型，才能使用lambda作为该接口的实例
 *
 * 备注：
 * 有且仅有一个抽象方法的接口，称为"函数式接口"
 * */
public class Demo03LambdaMore {
    public static void main(String[] args) {
        //JDK1.7之前，创建集合对象，必须把前后的泛型都写上
        ArrayList<String> list1 = new ArrayList<String>();

        //JDK1.7+之后，=后边的泛型可以省略，后边的泛型可以根据前边的泛型推导出来
        ArrayList<String> list2 = new ArrayList<>();

        //例1
        //使用lambda表达式，实现多线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "新线程创建了");
        }).start();

        //优化省略lambda
        new Thread(()->System.out.println(Thread.currentThread().getName() + "新线程创建了")).start();
        System.out.println("---------------------------------------------");

        //例2
        //使用lambda表达式，简化匿名内部类的书写
        invokeCook(() -> {
            System.out.println("吃饭啦");
        });

        //优化省略lambda
        invokeCook(()->System.out.println("吃饭啦"));
        System.out.println("---------------------------------------------");

        //例3
        //使用数组存储多个Person对象
        Person[] arr = {
                new Person("苍蓝星", 18),
                new Person("咩咩子", 100),
                new Person("雷娘", 50)
        };

        //使用lambda表达式，简化匿名内部类
        Arrays.sort(arr, (Person o1, Person o2)-> {
            return o1.getAge() - o2.getAge();
        });

        //优化省略lambda
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("---------------------------------------------");

        //例4
        //使用lambda表达式简化匿名内部类的缩写
        invokeCalc(120, 130, (int a, int b)->{
            return a + b;
        });

        //优化省略lambda
        invokeCalc(120, 130, (int a, int b)-> a + b);
    }

    //定义一个方法，参数传递Cook接口，方法内部调用Cook接口中的方法makeFood
    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }

    /*
     * 定义一个方法
     * 参数传递两个int类型的整数，Calculator接口
     * 方法内部调用Calculator中的方法计算两个整数的和
     */
    public static void invokeCalc(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println(sum);
    }
}
