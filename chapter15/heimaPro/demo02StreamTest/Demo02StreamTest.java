//练习：集合元素处理     Stream流方式
package chapter15.heimaPro.demo02StreamTest;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * 题目：
 * 有两个ArrayList集合存储队伍当中的多个成员姓名，要求使用传统的for循环(或增强for循环)依次进行以下操作：
 * 1、第一个队伍只要名字为3个字的成员姓名：存储到一个新集合中
 * 2、第一个队伍筛选之后只要前3个人：存储到一个新集合中
 * 3、第二个队伍只要姓张的成员姓名：存储到一个新集合中
 * 4、第二个队伍筛选之后不要前2个人：存储到一个新集合中
 * 5、将两个队伍合并为一个队伍：存储到一个新集合中
 * 6、根据姓名创建Person对象：存储到一个新集合中
 * 7、打印整个队伍的Person对象信息
 * */
public class Demo02StreamTest {
    public static void main(String[] args) {
        //第一个队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("苍蓝星");
        one.add("咩咩子");
        one.add("炎喵");
        one.add("雷娘");
        one.add("弟弟龙");
        one.add("冰呪龙");
        one.add("煌黑龙");

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("张三");
        two.add("李四");
        two.add("王五");
        two.add("张大麻子");
        two.add("张三丰");
        two.add("赵六");
        two.add("张一百");

        //1、第一个队伍只要名字为3个字的成员姓名：存储到一个新集合中
        //2、第一个队伍筛选之后只要前3个人：存储到一个新集合中
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);

        //3、第二个队伍只要姓张的成员姓名：存储到一个新集合中
        //4、第二个队伍筛选之后不要前2个人：存储到一个新集合中
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);

        //5、将两个队伍合并为一个队伍：存储到一个新集合中
        //6、根据姓名创建Person对象：存储到一个新集合中
        //7、打印整个队伍的Person对象信息
        Stream.concat(oneStream, twoStream).map(name->new Person(name)).forEach(p-> System.out.println(p));
    }
}
