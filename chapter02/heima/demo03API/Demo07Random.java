//习题一：生成要求范围的随机数
package chapter02.heima.demo03API;

import java.util.Random;
/*
 * 题目要求：
 * 根据int变量n的值，来获取随机数字，范围是[1, n]，可以取到1，也可以取到n
 *
 * 思路：
 * 1、定义一个int变量n，随意赋值
 * 2、要使用Random，三个步骤：导包、创建、使用
 * 3、如果写10，那么就是0~9，然而想要的是1~10，整体+1即可
 * 4、打印随机数字
 * */

public class Demo07Random {
    public static void main(String[] args) {
        int n = 5;
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            //整体+1，范围从[0,n)变成了[1,n+1)，即[1,n]
            int result = r.nextInt(n) + 1;
            System.out.println(result);
        }
    }
}