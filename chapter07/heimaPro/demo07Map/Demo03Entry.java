//Entry键值对对象，Map集合遍历
package chapter07.heimaPro.demo07Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map.Entry<K, V>：在Map接口中有一个内部接口Entry
 * 作用：当Map集合一创建，那么就会在Map集合中创建一个Entry对象，用来记录键与值(键值对对象，键与值得映射关系)
 *
 * Map集合遍历的第二种方式：使用Entry对象遍历
 *
 * Map集合中的方法：
 *      Set<Map.Entry<k, v>> entrySet() 返回此映射中包含的映射关系的Set视图
 *
 * Entry对象中有两种方法：
 *      getKey() 获取键
 *      getValue() 获取值
 *
 * 实现步骤：
 *      1、使用Map集合中的方法entrySet()，把Map集合中多个Entry对象取出来，存储到一个Set集合中
 *      2、遍历Set集合，获取每一个Entry对象
 *      3、使用Entry对象中的方法getKey()和getValue()获取键与值
 * */
public class Demo03Entry {
    public static void main(String[] args) {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();

        map.put("苍蓝星", 175);
        map.put("灭灭子", 2500);
        map.put("雷娘", 1500);

        // 1、使用Map集合中的方法entrySet()，把Map集合中多个Entry对象取出来，存储到一个Set集合中
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        //2、遍历Set集合，获取每一个Entry对象
        //使用迭代器遍历Set集合
        Iterator<Map.Entry<String, Integer>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            //3、使用Entry对象中的方法getKey()和getValue()获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        System.out.println("-------------------------------");

        //使用增强for循环
        for (Map.Entry<String, Integer> entry : set) {
            //3、使用Entry对象中的方法getKey()和getValue()获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }

    }
}
