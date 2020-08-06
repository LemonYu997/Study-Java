//Consumer接口中的默认方法andThen
package chapter14.heimaPro.demo03Function;

import java.util.function.Consumer;

/*
 * Consumer接口中的默认方法andThen，消费数据的时候，首先做一个操作，然后再做一个操作，实现组合
 * default Consumer<T> andThen(Consumer<? super T> after) {
 *       Objects.requireNonNull(after);
 *       return (T t) -> { accept(t); after.accept(t); };
 * }
 *
 * 作用：需要两个Consumer接口，可以把两个Consumer接口组合到一起，再对数据进行消费
 * 例如：
 * Consumer<String> con1
 * Consumer<String> con2
 * String s = "Hello";
 * con1.accept(s);
 * con2.accept(s);
 * 连接两个Consumer接口 再进行消费
 * con1.andThen(con2).accept(s);        谁写前边谁先消费
 * */
public class Demo04ConsumerAndThen {
    //定义一个方法，参数传递一个字符串和两个Consumer接口，Consumer接口的泛型使用字符串
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(s);
//        con2.accept(s);
        //使用andThen方法，把两个Consumer接口连接到一起，再消费数据
        con1.andThen(con2).accept(s);       //con1连接con2，先执行con1消费数据，再执行con2消费数据
    }

    public static void main(String[] args) {
        //调用method方法，传递一个字符串，两个Lambda表达式
        method("Hello",
                (t)->{
                    //消费方式：把字符串转换为大写输出
                    System.out.println(t.toUpperCase());
                },
                (t)->{
                    //消费方式：把字符串转为小写输出
                    System.out.println(t.toLowerCase());
                });
    }
}
