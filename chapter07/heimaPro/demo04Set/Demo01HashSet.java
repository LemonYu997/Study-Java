//HashSet集合
package chapter07.heimaPro.demo04Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * java.util.Set接口 extends Collection接口
 * Set接口的特点：
 *      1、不允许存储重复的元素
 *      2、没有索引，没有带索引的方法，也不能使用普通的for循环遍历，可以用增强for
 *
 * 方法和Collection中的一致
 *
 * Set的实现类：
 * HashSet：此类实现 Set 接口，由哈希表（实际上是一个 HashMap 实例）支持，不保证 set 的迭代顺序
 * LinkedHashSet：具有可预知迭代顺序的 Set 接口的哈希表和链接列表实现
 *
 * java.util.HashSet集合 implements Set接口
 * HashSet特点：
 *      1、不允许存储重复的元素
 *      2、没有索引，没有带索引的方法，也不能使用普通的for循环遍历，可以用增强for
 *      3、是一个无序的集合，存储元素和取出元素的顺序有可能不一致
 *      4、底层是一个哈希表(HashTable)结构，查询速度非常快
 * */
public class Demo01HashSet {
    public static void main(String[] args) {
        //多态
        Set<Integer> set = new HashSet<>();
        //使用add方法往集合中添加元素
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);     //重复元素

        //遍历，不能用for循环，可以用迭代器
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println(i);      //1 2 3
            //没有重复的元素1 并且输出顺序和输入顺序不同
        }
        System.out.println("--------");

        //可以使用增强for遍历
        for (Integer i : set) {
            System.out.println(i);
        }
        System.out.println("--------");
    }
}
