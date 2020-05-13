//1.6 大数值
package chapter1;

import java.math.BigInteger;
import java.util.Scanner;

//BigInteger类实现了任意精度的整数运算
//BigDecimal类实现了任意精度的浮点数运算

//利用大数值计算抽奖概率，可以以任意精度计算
public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw? ");
        int n = in.nextInt();

        //使用静态的valueOf方法将普通的数值转换为大数值
        BigInteger lotteryOdds = BigInteger.valueOf(1);

        //不能使用平时的运算符，要使用大数值类中的add和multiply等方法
        for (int i = 0; i <= k ; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1).divide(BigInteger.valueOf(i)));
            //注意上式的连续调用方法
        }

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}
