//Objects非空判断requireNonNull
package chapter05.heimaPro.demo01Exception;

import java.util.Objects;

/*
 * 判断参数中的对象是否为空，可以用以下方式
 *
 * Objects类中的静态方法：
 * public static <T> T requireNonNull(T obj)：查看指定引用对象不是null
 * 源码：
 *      public static <T> T requireNonNull(T obj) {
 *          if (obj == null)
 *              throw new NullPointerException();
 *          return obj;
 *      }
 * */
public class Demo04Objects {
    public static void main(String[] args) {
        method(null);       //NullPointerException: 传递的对象的值是null
    }

    public static void method(Object obj) {
        //对传递过来的参数进行合法性判断，判断是否为null
//        if (obj == null) {
//            throw new NullPointerException("传递的对象的值是null");
//        }

        //调用Objects类中的静态方法
//        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj, "传递的对象的值是null");
    }
}
