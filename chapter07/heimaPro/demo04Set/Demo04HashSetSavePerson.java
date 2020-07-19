//HashSet存储自定义类型元素
package chapter07.heimaPro.demo04Set;

import java.util.HashSet;

/*
 * HashSet存储自定义类型元素
 *
 * set集合保证元素唯一：
 *      存储的元素(String, Integer, ...Student...)，必须重写hashCode方法和equals方法
 *
 * 要求：
 *      同名同年龄的人，视为同一个人，只能存储一次
 * */
public class Demo04HashSetSavePerson {
    public static void main(String[] args) {
        //创建HashSet集合存储Person2
        HashSet<Person2> set = new HashSet<>();
        Person2 p1 = new Person2("Jack", 18);
        Person2 p2 = new Person2("Jack", 18);
        Person2 p3 = new Person2("Jack", 19);

        set.add(p1);
        set.add(p2);
        set.add(p3);

        //Person2类不重写hashCode和equals方法时
        System.out.println(p1.hashCode());      //460141958
        System.out.println(p2.hashCode());      //1163157884
        //equals默认方法比较地址值
        System.out.println(p1 == p2);           //false
        System.out.println(set);        //[Person2{name='Jack', age=19}, Person2{name='Jack', age=18}, Person2{name='Jack', age=18}]
        System.out.println("+--------------------------------------------------------");

        //Person2类重写了hashCode和equals方法时
        System.out.println(p1.hashCode());      //71329716
        System.out.println(p2.hashCode());      //71329716
        //equals默认方法比较地址值
        System.out.println(p1.equals(p2));      //true
        //不再出现重复元素
        System.out.println(set);        //[Person2{name='Jack', age=18}, Person2{name='Jack', age=19}]
    }
}
