//Stream流 传统方式遍历集合
package chapter15.heimaPro.demo01Stream;

import java.util.ArrayList;
import java.util.List;

/*
 * 使用传统的方式，遍历集合，对集合中的数据进行过滤
 * */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合，存储姓名
        List<String> list = new ArrayList<>();
        list.add("苍蓝星");
        list.add("咩咩子");
        list.add("雷娘");
        list.add("炎喵");
        list.add("苍火龙");

        //对List集合进行过滤，只要以苍开头的元素，存储到一个新集合中
        List<String> listA = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("苍")) {
                listA.add(s);
            }
        }

        //对ListA集合中的元素进行过滤，只要3个字符的元素，存储到一个新集合中
        List<String> listB = new ArrayList<>();
        for (String s : listA) {
            if (s.length() == 3) {
                listB.add(s);
            }
        }

        //遍历listB集合
        for (String s : listB) {
            System.out.println(s);
        }
    }
}
