//Collections中的sort方法
package chapter07.heimaPro.demo06Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
 * java.util.Collections 是集合工具类，用来对集合进行操作

 *      public static <T> void sort(List<T> list)：将集合中元素按照默认规则排序
 *
 * 【注意】
 * sort(list<T> list)方法的使用前提：
 * 被排序的集合里边存储的元素，必须实现Comparable接口，重写接口中的方法compareTo定义排序的规则
 *
 * Comparable接口排序的规则：
 *      自己(this) - 参数;      //升序
 *      参数 - 自己(this);      //降序
 * */
public class Demo02Sort {
    public static void main(String[] args) {
        //用整数测试排序方法
        System.out.println("用整数测试排序方法:");
        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 4, 2, 5, 3);
        System.out.println(list1);  //[1, 4, 2, 5, 3]

        //public static <T> void sort(List<T> list)：将集合中元素按照默认规则排序
        //默认规则是升序
        Collections.sort(list1);
        System.out.println(list1);  //[1, 2, 3, 4, 5]
        System.out.println("-------------------------------");

        //用字符串测试排序方法
        System.out.println("用字符串测试排序方法:");
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "c", "a", "b");
        System.out.println(list2);  //[c, a, b]
        //对字符串进行排序
        Collections.sort(list2);
        //根据字典顺序进行排序，a~z
        System.out.println(list2);  //[a, b, c]
        System.out.println("-------------------------------");

        //用自定义类型测试排序方法
        System.out.println("用自定义类型测试排序方法:");
        ArrayList<Person> list3 = new ArrayList<>();
        list3.add(new Person("Jack", 18));
        list3.add(new Person("Tom", 15));
        list3.add(new Person("苍蓝星", 16));
        System.out.println(list3);  //[Person{name='Jack', age=18}, Person{name='Tom', age=15}, Person{name='苍蓝星', age=16}]

        //默认规则排序会报错
//        Collections.sort(list3);      //报错

        //Person类实现Comparable接口后
        //按年龄升序排序
        Collections.sort(list3);
        System.out.println(list3);  //[Person{name='Tom', age=15}, Person{name='苍蓝星', age=16}, Person{name='Jack', age=18}]
    }
}
