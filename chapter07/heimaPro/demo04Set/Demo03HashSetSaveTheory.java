//Set集合不允许存储重复元素的原理
package chapter07.heimaPro.demo04Set;

import java.util.HashSet;

/*
 * Set集合不允许存储重复元素的原理
 * 前提：存储的元素必须重写hashCode方法和equals方法
 *
 * Set集合在调用add方法的时候，add方法会调用元素的hashCode方法和equals方法，判断元素是否重复
 * 说白了，先比较hashCode，再比较内容
 *
 * Set.add(s1);
 *      add方法会调用s1的hashCode方法，计算字符串"abc"的哈希值，哈希值是96354
 *      在集合中找有没有96354这个哈希值的元素，发现没有
 *      就会把s1存储到集合中
 *
 * set.add(s2);
 *      add方法会调用s2的hashCode方法，计算字符串"abc"的哈希值，哈希值是96354
 *      在集合中找有没有96354这个哈希值的元素，发现有(哈希冲突)
 *      s2会调用equals方法和哈希值相同的元素进行比较 s2.equals(s1)，返回true
 *      两个元素的哈希值相同，equals返回true，认定两个元素相同
 *      就不会把s2存储到集合中
 * */
public class Demo03HashSetSaveTheory {
    public static void main(String[] args) {
        //创建HashSet对象
        HashSet<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");      //重复
        set.add(s1);
        set.add(s2);
        set.add("重地");
        set.add("通话");
        set.add("abc");     //重复

        System.out.println(set);        //[重地, 通话, abc]
    }
}
