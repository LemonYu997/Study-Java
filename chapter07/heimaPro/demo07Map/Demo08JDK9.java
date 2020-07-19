//JDK9新特性
package chapter07.heimaPro.demo07Map;

import java.util.List;
import java.util.Set;

/*
 * JDK9的新特性：
 * List接口，Set接口，Map接口：里边增加了一个静态的新方法of
 * 可以给集合一次性添加多个元素
 *
 * static <E> List<E> of (E... Elements)
 *
 * 使用前提：
 *      当集合中存储的元素的个数已经确定了，不再改变时使用
 *
 * 注意：
 *      1、of方法只使用于List接口，Set接口，Map接口，不适用于接口的实现类
 *      2、of方法的返回值是一个不能改变的集合，集合不能再使用add，put方法添加元素，会抛出异常
 *      3、Set接口和Map接口在调用of方法的时候，不能有重复的元素，否则会抛出异常
 * */
public class Demo08JDK9 {
    public static void main(String[] args) {
        //由于使用的是JDK8，无法使用此方法，全部注释掉了
//        List<String> list = List.of("a", "b", "c", "d", "e");
//        System.out.println(list);       //[a, b, c, d, e]
        //List.add("w");        //UnsupportedOperationException不支持操作异常

//        Set<String> set = new Set.of("a", "b", "c", "d", "a");  //IllegalArgumentException：非法参数异常，有重复的元素
//        System.out.println(set);
        //set.add("w");         //UnsupportedOperationException不支持操作异常
    }
}
