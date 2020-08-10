//练习：集合元素处理     传统方式
package chapter15.heimaPro.demo02StreamTest;

import java.util.ArrayList;

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
public class Demo01StreamTest {
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
        ArrayList<String> one1 = new ArrayList<>();
        for (String name : one) {
            if (name.length() == 3) {
                one1.add(name);
            }
        }
        //2、第一个队伍筛选之后只要前3个人：存储到一个新集合中
        ArrayList<String> one2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one2.add(one1.get(i));      //i = 0, 1, 2
        }

        //3、第二个队伍只要姓张的成员姓名：存储到一个新集合中
        ArrayList<String> two1 = new ArrayList<>();
        for (String name : two) {
            if (name.startsWith("张")) {
                two1.add(name);
            }
        }

        //4、第二个队伍筛选之后不要前2个人：存储到一个新集合中
        ArrayList<String> two2 = new ArrayList<>();
        for (int i = 2; i < two1.size(); i++) {
            two2.add(two1.get(i));      //i 不含0, 1
        }

        //5、将两个队伍合并为一个队伍：存储到一个新集合中
        ArrayList<String> all = new ArrayList<>();
        all.addAll(one2);
        all.addAll(two2);

        //6、根据姓名创建Person对象：存储到一个新集合中
        ArrayList<Person> list = new ArrayList<>();
        for (String name : all) {
            list.add(new Person(name));
        }

        //7、打印整个队伍的Person对象信息
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
