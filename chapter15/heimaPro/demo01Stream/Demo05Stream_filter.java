//Stream流中的常用方法——filter     延迟方法
package chapter15.heimaPro.demo01Stream;

import java.util.stream.Stream;

/*
 * Stream流中的常用方法_filter：用于对Stream流中的数据进行过滤
 * Stream<T> filter(Predicate<? super T> predicate);
 * filter方法的参数Predicate是一个函数式接口，所以可以传递Lambda表达式，对数据进行过滤
 * Predicate中的抽象方法：
 *      boolean test(T t);
 * */
public class Demo05Stream_filter {
    public static void main(String[] args) {
        //创建一个Stream流
        Stream<String> stream = Stream.of("苍蓝星", "咩咩子", "雷娘", "苍火龙", "炎喵");

        //对Stream流中的元素进行过滤，只要苍开头的元素
        Stream<String> stream2 = stream.filter((String name) -> {
            return name.startsWith("苍");
        });
        //遍历stream2
        stream2.forEach(name-> System.out.println(name));

        /*
         * Stream流属于管道流，只能被消费(使用)一次
         * 第一个Stream流调用完毕方法，数据会流转到下一个Stream上，
         * 这时第一个Stream流已经使用完毕，就会关闭，第一个Stream流就不能再调用方法
         * java.lang.IllegalStateException: stream has already been operated upon or closed
         * */
        //异常
//        stream.forEach(name-> System.out.println(name));    //java.lang.IllegalStateException: stream has already been operated upon or closed


        //优化写法
//        stream.filter(name->name.startsWith("苍")).forEach(name-> System.out.println(name));
    }
}
