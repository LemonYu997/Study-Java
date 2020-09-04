//ArrayList习题三
package chapter02.heima.demo04ArrayList;

/*
 * 题目：
 * 定义以指定格式打印集合的方法(ArrayList类型作为参数)，使用{}扩起集合，使用@分隔每个元素
 * 格式参照{元素@元素@元素}
 *
 * System.out.println(list);        [10, 20, 30]
 * printArrayList(list);            {10@20@30}
 * */

import java.util.ArrayList;

public class Demo08ArrayListTest03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jack");
        list.add("Jerry");
        System.out.println(list);       //不用这种

        printArrayList(list);
    }

    /*
     * 定义方法的三要素：
     * 返回值类型：void
     * 方法名称：printArrayList
     * 参数列表：ArrayList
     * */
    public static void printArrayList(ArrayList<String> list) {
        //{10@20@30}
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            //最后一个元素
            if (i == list.size() - 1) {
                System.out.println(name + "}");
            } else {    //不是最后一个元素
                System.out.print(name + "@");
            }

        }
    }
}
