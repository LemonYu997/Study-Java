//Map集合遍历 键找值 的方法
package chapter07.heimaPro.demo07Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map集合的第一种遍历方式：通过键找值的方式
 * Map集合中的方法：
 *      public Set<K> keySet() 返回此映射中所包含的键的 Set 视图
 *      把Map集合中所有的key取出来存储到Set集合中
 *
 * 实现步骤：
 *      1、使用Map集合中的方法keySet()，把Map集合所有的key取出来，存储到一个Set集合中
 *      2、遍历set集合，获取Map集合中的每一个key
 *      3、通过Map集合中的方法get(key)，同过key找到value
 * */
public class Demo02MapTraversal {
    public static void main(String[] args) {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();

        map.put("苍蓝星", 175);
        map.put("灭灭子", 2500);
        map.put("雷娘", 1500);

        //1、使用Map集合中的方法keySet()，把Map集合所有的key取出来，存储到一个Set集合中
        Set<String> set = map.keySet();
        //2、遍历set集合，获取Map集合中的每一个key
        //使用迭代器遍历set集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            //3、通过Map集合中的方法get(key)，同过key找到value
            Integer i = map.get(key);
            System.out.println(key + "=" + i);
        }
        System.out.println("--------------------");

        //使用增强for遍历Set集合
        for (String key : set) {
            //3、通过Map集合中的方法get(key)，同过key找到value
            Integer i = map.get(key);
            System.out.println(key + "=" + i);
        }
        System.out.println("--------------------");

        //简化使用增强for循环，一步到位
        //1、使用Map集合中的方法keySet()
        //2、遍历set集合，获取Map集合中的每一个key
        for (String key : map.keySet()) {       //匿名对象
            //3、通过Map集合中的方法get(key)，同过key找到value
            Integer i = map.get(key);
            System.out.println(key + "=" + i);
        }
    }
}
