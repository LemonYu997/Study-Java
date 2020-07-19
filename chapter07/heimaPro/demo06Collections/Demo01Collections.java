//Collections常用方法
package chapter07.heimaPro.demo06Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
 * java.util.Collections 是集合工具类，用来对集合进行操作
 * 此类完全由在 collection 上进行操作或返回 collection 的静态方法组成
 *
 * 部分方法如下：
 *      public static <T> boolean addAll(Collection<T> c, T ... elements)：往集合中添加一些元素
 *      public static void shuffle(List<?> list)：打乱集合顺序
 * */
public class Demo01Collections {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        //往集合中添加多个元素
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        System.out.println(list);   //[a, b, c, d]

        //public static <T> boolean addAll(Collection<T> c, T ... elements)：往集合中添加一些元素
        Collections.addAll(list, "a", "b", "c", "d");
        System.out.println(list);    //[a, b, c, d]

        //public static void shuffle(List<?> list)：打乱集合顺序
        Collections.shuffle(list);
        //每次执行顺序不同
        System.out.println(list);   //[d, b, c, a]
    }
}
