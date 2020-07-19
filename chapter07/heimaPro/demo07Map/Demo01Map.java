//Map集合及其常用方法
package chapter07.heimaPro.demo07Map;

/*
 * java.util.Map<k, v>集合 是一个接口
 * Map集合的特点：
 *      1、Map集合是一个双列集合，一个元素包含两个值(一个key，一个Value)
 *      2、Map集合中的元素，key和value的数据类型可以相同，也可以不同
 *      3、Map集合中的元素，key是不允许重复的，value是可以重复的
 *      4、Map集合中的元素，key和value是一一对应的
 *
 * Map的常用实现类：
 *      java.util.HashMap<k, v>集合 implements Map<k, v>接口
 *      java.util.LinkedHashMap<k, v>集合 extends Hashmap<k, v>集合 implements Map<k, v>接口
 *
 * HashMap<k, v>集合的特点：
 *      1、HashMap集合底层是哈希表：查询的速度特别快
 *          JDK1.8之前：数组+单向链表
 *          JDK1.8+：数组+单项链表/红黑树(链表长度超过8时)，提高查询的速度
 *      2、HashMap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致
 *
 * LinkedHashMap<k, v> 特点：
 *      1、LinkedHashMap集合底层时哈希表+链表(保证迭代的顺序)
 *      2、LinkedHashMap是一个有序的集合，存储元素和取出元素的顺序一致
 *
 * Map常用方法：
 *      V put(K key, V value) 将指定的值与此映射中的指定键关联
 *      public V remove(Object key) 从此映射中移除指定键的映射关系（如果存在）
 *      public V get(Object key) 返回指定键所映射的值；如果对于该键来说，此映射不包含任何映射关系，则返回 null
 *      public boolean containsKey(Object key) 如果此映射包含对于指定键的映射关系，则返回 true
 * */

import java.util.HashMap;
import java.util.Map;

public class Demo01Map {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
        show04();
    }

    /*
     * V put(K key, V value)：把指定的键与指定的值添加到Map集合中
     * 返回值： v
     *      存储键值对的时候，key不重复，返回值v是null
     *      存储键值对的时候，key重复，会使用新的value替换Map中重复的value，返回被替换的value值
     * */
    private static void show01() {
        //创建Map集合对象，多态
        Map<String, String> map = new HashMap<>();

        String v1 = map.put("苍蓝星", "灭灭子");
        //key不重复，返回值v是null
        System.out.println("v1:" + v1);         //v1:null

        String v2 = map.put("苍蓝星", "雷娘");
        //key重复，会使用新的value替换map中重复的value，返回被替换的value值
        System.out.println("v2:" + v2);         //v2:灭灭子

        System.out.println(map);                //{苍蓝星=雷娘}

        map.put("炎喵", "娜娜");
        map.put("金黄澄月", "银白曜日");

        System.out.println(map);                //{苍蓝星=雷娘, 炎喵=娜娜, 金黄澄月=银白曜日}
        System.out.println("--------------------------------------------");
    }

    /*
     * public V remove(Object key)：把指定的键 所对应的键值对元素，在Map集合中删除，返回被删除的元素
     * 返回值：v
     *      key存在，v返回被删除值
     *      key不存在，v返回null
     * */
    private static void show02() {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();

        map.put("苍蓝星", 175);
        map.put("灭灭子", 2500);
        map.put("雷娘", 1500);
        System.out.println(map);            //{雷娘=1500, 苍蓝星=175, 灭灭子=2500}

        Integer v1 = map.remove("灭灭子");
        // key存在，v返回被删除值
        System.out.println("v1:" + v1);     //v1:2500
        System.out.println(map);            //{雷娘=1500, 苍蓝星=175}

        Integer v2 = map.remove("炎喵");
        //如果使用自动拆箱功能
//        int v2 = map.remove("炎喵");   //返回值为空时，会产生一个空指针异常NullPointerException

        //key不存在，v返回null
        System.out.println("v2:" + v2);     //v2:null
        System.out.println(map);            //{雷娘=1500, 苍蓝星=175}
        System.out.println("--------------------------------------------");
    }

    /*
     * public V get(Object key)：根据指定的键，在Map集合中获取对应的值
     * 返回值：
     *      key存在，返回对应的value值
     *      key不存在，返回null值
     * */
    private static void show03() {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();

        map.put("苍蓝星", 175);
        map.put("灭灭子", 2500);
        map.put("雷娘", 1500);

        Integer v1 = map.get("苍蓝星");
        //key存在，返回对应的value值
        System.out.println("v1:" + v1);     //v1:175

        Integer v2 = map.get("炎喵");
        //key不存在，返回null值
        System.out.println("v2:" + v2);
        System.out.println("--------------------------------------------");
    }

    /*
     * public boolean containsKey(Object key)：判断集合中是否包含指定的键
     * 包含返回true，不包含返回false
     * */
    private static void show04() {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();

        map.put("苍蓝星", 175);
        map.put("灭灭子", 2500);
        map.put("雷娘", 1500);

        boolean b1 = map.containsKey("苍蓝星");
        System.out.println(b1);     //true
        boolean b2 = map.containsKey("炎喵");
        System.out.println(b2);     //false
    }
}
