//1.8数组排序
package chapter1;

import java.util.Arrays;
import java.util.Scanner;

//Arrays.sort()方法学习
public class Test08LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        //创建一个存放所有数的数组  1, 2, 3, ..., n
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        //将抽奖结果放入一个新数组 数组大小是抽取k个数
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            //生成一个随机数
            int r = (int)(Math.random() * n);
            /*注释：
            * Math.random()方法可以生成一个0~1（不含1）的随机浮点数，用其乘以n可以得到一个0~n-1之间的随机数
            * */


            //将生成的随机数当作抽奖结果放入result数组中
            //numbers[r]的值为 r + 1， 因为numbers是从0开始的数组
            result[i] = numbers[r];

            //将numbers数组的最后一个元素与numbers[r]进行替换，防止重复抽取
            //并使n--，相当于删除原先的最大元素
            numbers[r] = numbers[n - 1];
            n--;
        }

        //使用Arrays.sort方法进行数组排序
        Arrays.sort(result);

        //输出抽奖结果
        System.out.println("Bet the following combination. It'll make you rich!");
        for (int r: result)
            System.out.println(r);
    }
}
