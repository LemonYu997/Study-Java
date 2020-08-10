//Stream流 遍历、过滤集合
package chapter15.heimaPro.demo01Stream;

import java.util.ArrayList;
import java.util.List;

/*
 * 使用Stream流的方式，遍历集合，对集合中的数据进行过滤
 * Stream流是JDK1.8+出现的
 * 关注的是做什么，而不是怎么做
 * */
public class Demo02Stream {
    public static void main(String[] args) {
        //创建一个List集合，存储姓名
        List<String> list = new ArrayList<>();
        list.add("苍蓝星");
        list.add("咩咩子");
        list.add("雷娘");
        list.add("炎喵");
        list.add("苍火龙");

        //对List集合进行过滤，只要以苍开头的元素，存储到一个新集合中
        //对ListA集合中的元素进行过滤，只要3个字符的元素，存储到一个新集合中
        //遍历listB集合
        list.stream()
                .filter(name->name.startsWith("苍"))
                .filter(name->name.length() == 3)
                .forEach(name-> System.out.println(name));
    }
}
