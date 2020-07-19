package chapter07.heimaPro.demo06Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * java.util.Collections 是集合工具类，用来对集合进行操作

 * public static <T> void sort(List<T> list, Comparator<? super T>)：将集合中元素按照指定排序
 *
 * Comparator和Comparable接口区别：
 *      Comparable：自己(this)和别人(参数)比较，自己需要实现Comparable接口，重写比较的规则CompareTo方法
 *      Comparator：相当于找一个第三方的裁判，进行比较
 *
 * Comparator排序规则：
 *      o1 - o2：升序
 *      o2 - o1：降序
 */
public class Demo03Sort {
    public static void main(String[] args) {
        //整数排序
        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 4, 2, 5, 3);
        System.out.println(list1);      //[1, 4, 2, 5, 3]

        //参数是一个匿名对象加匿名内部类
        Collections.sort(list1, new Comparator<Integer>() {
            //重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;     //降序排序
            }
        });

        System.out.println(list1);      //[5, 4, 3, 2, 1]

        //自定义类型排序
        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student("Jack", 18));
        list2.add(new Student("Tom", 28));
        list2.add(new Student("苍蓝星", 10));
        System.out.println(list2);      //[Student{name='Jack', age=18}, Student{name='Tom', age=28}, Student{name='苍蓝星', age=10}]

        Collections.sort(list2, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序排序
                int result =  o1.getAge() - o2.getAge();
                //如果两个人年龄相同，再使用姓名的第一个字比较
                if (result == 0) {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });

        System.out.println(list2);      //[Student{name='苍蓝星', age=10}, Student{name='Jack', age=18}, Student{name='Tom', age=28}]
    }
}
