//HashMap存储自定义类型键值
package chapter07.heimaPro.demo07Map;

/*
 * HashMap存储自定义类型键值
 * Map集合保证key是唯一的：
 *      作为key的元素，必须重写hashCode方法和equals方法，以保证key唯一
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo04HashMap {
    public static void main(String[] args) {
        show01();
        show02();
    }

    /*
     * HashMap存储自定义类型键值
     * key：String类型
     *      String类重写hashCode方法和equals方法，可以保证唯一
     * value：Person类型
     *      value可以重复(同名同年龄的人视为同一个人)
     * */
    private static void show01() {
        //创建HashMap集合
        HashMap<String, Person> map = new HashMap<>();
        //往集合中添加元素
        map.put("新大陆", new Person("苍蓝星", 18));
        map.put("冰原", new Person("冰咒", 180));
        map.put("聚魔", new Person("灭灭子", 100));
        map.put("新大陆", new Person("炎喵", 200));      //key值重复，替换
        //使用keySet加上增强for遍历Map集合
        Set<String> set = map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key + "-->" + value);
        }

        System.out.println("---------------------------------");
//        冰原-->Person{name='冰咒', age=180}
//        新大陆-->Person{name='炎喵', age=200}
//        聚魔-->Person{name='灭灭子', age=100}
    }

    /*
     * HashMap存储自定义类型键值
     * key：Person类型
     *      Person类【必须】重写hashCode方法和equals方法，可以保证唯一
     * value：String类型
     *      可以重复
     * */
    private static void show02() {
        //创建HashMap集合
        HashMap<Person, String> map = new HashMap<>();
        //往集合中添加元素
        map.put(new Person("苍蓝星", 18), "新大陆");
        map.put(new Person("冰咒", 180), "冰原");
        map.put(new Person("灭灭子", 100), "聚魔");
        map.put(new Person("灭灭子", 100), "新大陆");
        //使用EntrySet和增强for
        Set<Map.Entry<Person, String>> set = map.entrySet();
        for (Map.Entry<Person, String> entry : set) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-->" + value);
        }

        //没用重写hashCode方法和equals方法，不能保证唯一性
//        Person{name='灭灭子', age=100}-->聚魔
//        Person{name='冰咒', age=180}-->冰原
//        Person{name='苍蓝星', age=18}-->新大陆
//        Person{name='灭灭子', age=100}-->新大陆

//        重写hashCode方法和equals方法，保证唯一性
//        Person{name='苍蓝星', age=18}-->新大陆
//        Person{name='灭灭子', age=100}-->新大陆
//        Person{name='冰咒', age=180}-->冰原
    }
}
