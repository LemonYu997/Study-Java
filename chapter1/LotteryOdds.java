//1.5 for循环
package chapter1;

import java.util.Scanner;

//for循环学习
//计算抽奖的概率。从1~50个数字中抽取6个数字抽奖，中奖概率是1/15890700
public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw? ");
        int n = in.nextInt();

        //计算中奖概率
        //公式为: n * (n-1) * (n-2) * ... * (n-k+1) / (1*2*3*...k)
        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds * (n - i + 1) / i;

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}
