//LinkedHashSet
package chapter07.heimaPro.demo04Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
 * java.util.LinkedHashSet集合 extends HashSet集合
 * LinkedHashSet集合特点：
 *      底层是一个哈希表(数组 + 链表/红黑树) + 链表：多了一条链表(记录元素的存储顺序)，保证元素有序
 * */
public class Demo05LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("CLX");
        //HashSet 输出顺序和输入顺序不同，无序并且不允许重复元素
        System.out.println(set);        //[abc, www, CLX]

        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("www");
        linked.add("abc");
        linked.add("abc");
        linked.add("CLX");
        //LinkedHashSet 输出顺序和输入顺序相同，有序并且不允许重复元素
        System.out.println(linked);        //[www, abc, CLX]
    }
}
