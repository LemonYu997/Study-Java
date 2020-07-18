//斗地主案例
package chapter06.heimaPro.demo02Test;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 规则：54张牌打乱顺序，三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留做底牌
 *
 * 分析：
 * 1、准备牌
 * 牌可以设计为ArrayList<String>，每个字符串为一张牌
 * 每张牌由花色数字两部分组成，可以使用花色集合与数字集合嵌套迭代完成每张牌的组装
 * 2、洗牌
 * 牌由Collections类的shuffle方法进行随机排序
 * 3、发牌
 * 将每个人以及底牌设计为ArrayList<String>，将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌
 * 4、看牌
 * 直接打印每个集合
 * */
public class Main {
    public static void main(String[] args) {
        /*
         * 1、准备牌
         * */
        //定义一个存储54张牌的ArrayList集合，泛型使用String
        ArrayList<String> poker = new ArrayList<>();
        //定义两个数组，一个数组存储牌的花色，一个数组存储牌的序号
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //先把大王和小王存储到poker集合中
        poker.add("大王");
        poker.add("小王");
        //循环嵌套遍历两个数组，组装52张牌
        for (String number : numbers) {
            for (String color : colors) {
                //看看效果
//                System.out.println(color + number);
                //把组装好的牌存储到poker集合中
                poker.add(color + number);
            }
        }
        //看看存储后的效果
        System.out.println(poker);


        /*
         * 2、洗牌
         * 使用集合的工具类Collections中的方法
         * static void shuffle(List<?> list) 使用默认随机源对指定列表进行置换
         */
        Collections.shuffle(poker);
        //洗牌后的顺序
        System.out.println(poker);

        /*
         * 3、发牌
         * */
        //定义4个集合，存储玩家牌和底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        /*
         * 遍历poker集合，获取每一张牌
         * 使用poker集合的索引 % 3，给三个玩家轮流发牌
         * 剩余3张牌给底牌
         * 注意：
         *      先判断底牌(i >= 51)，否则牌就发没了
         * */
        for (int i = 0; i < poker.size(); i++) {
            //获取每一张牌
            String p = poker.get(i);
            //轮流发牌
            if (i >= 51) {
                //底牌发牌
                dipai.add(p);
            } else if(i % 3 == 0) {
                //给玩家1发牌
                player1.add(p);
            } else if(i % 3 == 1) {
                //给玩家1发牌
                player2.add(p);
            } else if(i % 3 == 2) {
                //给玩家1发牌
                player3.add(p);
            }
        }

        //4、看牌
        System.out.println("刘德华：" + player1);
        System.out.println("周润发：" + player2);
        System.out.println("周星驰：" + player3);
        System.out.println("底牌：" + dipai);
    }
}
