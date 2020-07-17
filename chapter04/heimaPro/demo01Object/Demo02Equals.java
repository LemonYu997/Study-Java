//Object类的Equals方法
package chapter04.heimaPro.demo01Object;

import java.util.ArrayList;

public class Demo02Equals {
    public static void main(String[] args) {
        /*
         * Person类默认继承了Object类，所以可以使用Object类的equals方法
         * public boolean equals(Object obj)
         * 指示其他某个对象是否与此对象“相等”。
         * equals方法源码：
         *      public boolean equals(Object obj) {
         *              return (this == obj);
         *      }
         * 参数：
         *      Object obj：可以传递任意的对象
         *      == 比较运算符，返回的是一个布尔值 true/false
         *      基本数据类型：比较的是值
         *      引用数据类型：比较的是两个对象的地址值
         * this是谁？
         *      哪个对象调用的方法，方法中的this就是对象；p1调用的equals方法所以this就是p1
         * obj是谁？
         *      传递过来的参数p2
         * this == obj --> p1 == p2
         * */
        Person p1 = new Person("Jack", 18);
        Person p2 = new Person("Tom", 20);
        Person p3 = new Person("Tom", 20);

//        //调用equals()方法，比较两个对象的地址值
//        boolean b = p1.equals(p2);
//        System.out.println(b);              //false
//
//        //把p2的地址值赋给p1
//        p1 = p2;
//        //重新比较
//        b = p1.equals(p2);
//        System.out.println(b);              //true

        //比较地址值没什么意义，在Person类中进行重写
        //重写equals方法后的比较
        boolean b1 = p1.equals(p2);
        System.out.println(b1);                //false
        boolean b2 = p2.equals(p3);
        System.out.println(b2);                //true
        System.out.println("--------------------");

        //重写后有新问题，equals方法中的参数是Object类，在
        // Person类中使用了强转，此时若用其他类作为参数
        //会产生ClassCastException异常
        ArrayList<String> list = new ArrayList<>();
        boolean b3 = p1.equals(list);
        System.out.println(b3);                 //false

        //传递null类型
        boolean b4 = p1.equals(null);
        System.out.println(b4);                 //false

        //比较本身
        boolean b5 = p1.equals(p1);
        System.out.println(b5);                 //true
    }
}
