//定义和使用含有泛型的接口
package chapter06.heimaPro.demo01Generic;

/*
 * 测试含有泛型的接口
 *
 * 含有泛型的接口
 * 第一种使用方式：定义接口的实现类，实现接口，指定接口的泛型
 * public interface Iterator<E> {
 *      E next();
 * }
 * Scanner类实现了Iterator接口，并指定接口的泛型为String，所以重写next()方法，泛型默认就是String
 * public final class Scanner implements Iterator<String> {
 *      public String next() {};
 * }
 *
 * 第二种使用方式：接口使用泛型，实现类就使用什么泛型，类跟着接口走
 * 就相当于定义了一个含有泛型的类，创建对象的时候确定泛型的类型
 * public interface List<E> {
 *      boolean add(E e);
 *      E get(int index);
 * }
 * public class ArrayList<E> {
 *      public boolean add(E, e) {}
 *      public E get(int index) {}
 * }
 * */
public class Demo04GenericInterface {
    public static void main(String[] args) {
        //第一种实现方式，实现类已经指定了泛型类型
        //创建GenericInterfaceImpl1对象
        GenericInterfaceImpl1 gi1 = new GenericInterfaceImpl1();
        gi1.method("字符串");

        //第二种实现方式，创建对象时再指定泛型类型
        //创建GenericInterfaceImpl2对象
        GenericInterfaceImpl2<Integer> gi2 = new GenericInterfaceImpl2();
        gi2.method(254);

        GenericInterfaceImpl2<Double> gi3 = new GenericInterfaceImpl2();
        gi3.method(2.5);
    }
}
