//Hashtable集合
package chapter07.heimaPro.demo07Map;

import java.util.HashMap;
import java.util.Hashtable;

/*
 * java.util.Hashtable<k, v>集合 implements Map<k, v>接口
 *
 * Hashtable：底层是一个哈希表，是一个线程安全集合，是单线程集合，速度慢
 * HashMap：底层是一个哈希表，是一个线程不安全的集合，是多线程的集合，速度快
 *
 * HashMap集合（之前所有集合）：可以存储null值，null键
 * Hashtable集合：不能存储null值，null键
 *
 * Hashtable和Vector集合一样，在JDK1.2版本之后被更先进的集合(HashMap, ArrayList)取代了
 * Hashtable的子类Properties依然活跃在历史的舞台
 * Properties集合是一个唯一和IO流相结合的集合
 * */
public class Demo06Hashtable {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "a");
        map.put("b", null);
        map.put(null, null);
        System.out.println(map);    //{null=null, b=null}

        Hashtable<String, String> table = new Hashtable<>();
//        table.put(null, "a");   //NullPointerException
//        table.put("b", null);   //NullPointerException
//        map.put(null, null);    //NullPointerException
    }
}
