//泛型接口实现
package chapter06.heimaPro.demo01Generic;

/*
 * 含有泛型的接口，第一种使用方式：定义接口的实现类，实现接口，指定接口的泛型
 * public interface Iterator<E> {
 *      E next();
 * }
 * Scanner类实现了Iterator接口，并指定接口的泛型为String，所以重写next()方法，泛型默认就是String
 * public final class Scanner implements Iterator<String> {
 *      public String next() {};
 * }
 * */
public class GenericInterfaceImpl1 implements GenericInterface<String>{
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
