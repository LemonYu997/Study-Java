//遍历集合
package chapter02.heima.demo04Array;

import java.util.ArrayList;

public class Demo04ArrayListEach {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Mercy");

        //遍历集合
        //快捷输入list.fori
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
