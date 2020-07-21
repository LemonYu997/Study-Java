//斗地主综合案例
package chapter07.heimaPro.demo09Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * 斗地主综合案例：有序版本
 * 1、准备牌
 * 2、洗牌
 * 3、发牌
 * 4、排序
 * 5、看牌
 * */
public class DouDiZhu {
    public static void main(String[] args) {
        /*
         * 1、准备牌
         * 用Map存储牌的索引和组装好的牌
         * 用1个List存储牌的索引
         * 用2个List存储牌的花色和序号，使用循环嵌套，将其存储到Map中
         * */
        //创建一个Map集合，存储牌的索引和组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();
        //创建一个List集合，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，存储花色和牌的序号
        List<String> colors = new ArrayList<>();
        Collections.addAll(colors, "♠", "♥", "♣", "♦");
        List<String> numbers = new ArrayList<>();
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //把大王和小王存储到集合中
        //定义一个牌的索引
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;

        //循环嵌套遍历两个集合，组装52张牌，存储到Map集合中
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }
        }
        //看看效果
//        System.out.println(poker);
//        System.out.println(pokerIndex);

        /*
         * 2、洗牌
         * 使用Collections中的方法shuffle(List)
         * */
        Collections.shuffle(pokerIndex);        //打乱索引即打乱牌序
        //看看效果
//        System.out.println(pokerIndex);

        /*
         * 3、发牌
         * 定义4个List集合，3个玩家一个底牌，存放牌的索引
         * 用取模发牌，最后3张给底牌
         * */
        //定义4个集合，存储玩家牌的索引和底牌的索引
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        //遍历存储牌的索引的List集合，获取每一个素银
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            //先判断底牌
            if (i >= 51) {
                //给底牌发牌
                diPai.add(in);
            } else if(i % 3 == 0) {
                //给玩家1发牌
                player1.add(in);
            } else if(i % 3 == 1) {
                //给玩家2发牌
                player2.add(in);
            } else if(i % 3 == 2) {
                //给玩家3发牌
                player3.add(in);
            }
        }
        //看看效果
//        System.out.println(player1);
//        System.out.println(player2);
//        System.out.println(player3);
//        System.out.println(diPai);

        /*
         * 4、排序
         * 使用Collections中的方法sort(List)
         * 默认是升序排序
         * */
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);

        /*
         * 5、看牌
         * 遍历每一个集合，得到索引值，通过索引值在Map集合中查找牌的花色和数字
         * 定义一个看牌的方法，提高代码的复用性
         * 调用看牌的方法
         * */
        lookPoker("苍蓝星", poker, player1);
        lookPoker("咩咩子", poker, player2);
        lookPoker("炎喵", poker, player3);
        lookPoker("底牌", poker, diPai);
    }

    /*
     * 定义一个看牌的方法，提高代码的复用性
     * 参数：
     *      String name：玩家名称
     *      HashMap<Integer, String> poker：存储牌的poker集合
     *      ArrayList<Integer> list：存储玩家和底牌的list集合
     * 查表法：
     *      遍历玩家或者底牌集合，获取牌的索引
     *      使用牌的索引，去Map集合中，找到对应的牌
     * */
    public static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        //输出玩家名称，不换行
        System.out.print(name + ": ");
        //遍历玩家或者底牌集合，获取牌的索引
        for (Integer key : list) {
            //使用牌的索引，去Map集合中，找到对应的牌
            String value = poker.get(key);
            System.out.print(value + " " );
        }
        System.out.println();   //打印完每一个玩家的牌换行
    }
}
