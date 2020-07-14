//Random类学习
package chapter02.heima.demo03API;

/*
 * Random类用来生成随机数字，使用时三个步骤：
 *
 * 1、导包
 * import java.util.Random;
 *
 * 2、创建
 * Random r = new Random();     //小括号当中留空
 *
 * 3、使用
 * 获取一个随机的int数字(范围是int所有范围，有正负两种):
 * int num = r.nextInt();
 * 获取一个随机的int数字(参数代表了范围，左闭右开区间):
 * int num = r.nextInt(3);      //实际上代表的含义是：[0,3)，也就是0~2
 * */

import java.util.Random;

public class Demo06Random {
    public static void main(String[] args) {
        Random r = new Random();

        int one = r.nextInt();                     //int所有范围，有正负两种
        System.out.println("第一个随机数是: " + one);

        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(10);        //范围实际上是0~9
            System.out.println(num);
        }
    }
}
