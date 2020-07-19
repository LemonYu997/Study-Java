//LinkedHashMap集合
package chapter07.heimaPro.demo07Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
 * java.util.LinkedHashMap<k, v> extends HashMap<k, v>
 * Map接口的哈希表和链接表实现，具有可预知的迭代顺序
 * 底层原理：
 *      哈希表 + 链表(记录元素的顺序)
 * */
public class Demo05LinkedHashMap {
    public static void main(String[] args) {
        //HashMap特点
        //key不允许重复，无序
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("c", "b");
        map.put("b", "d");
        map.put("a", "f");
        System.out.println(map);        //{a=f, b=d, c=b}       无序

        //LinkedHashMap特点
        //key不允许重复，有序
        LinkedHashMap<String, String> linked = new LinkedHashMap<>();
        linked.put("a", "b");
        linked.put("c", "b");
        linked.put("b", "d");
        linked.put("a", "f");
        System.out.println(linked);     //{a=f, c=b, b=d}       有序，和输入顺序一致
        //a=f在第一项是因为同key，发生了替换
    }
}
