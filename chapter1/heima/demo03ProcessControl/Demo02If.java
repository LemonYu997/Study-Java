//流程控制2-判断语句if
package chapter1.heima.demo03ProcessControl;

public class Demo02If {
    public static void main(String[] args) {
        if1();
        if2();
        if3();
        max();
    }

    //单if语句
    public static void if1() {
        System.out.println("看到网吧");
        int age = 16;
        if (age >= 18) {
            System.out.println("进入网吧");
            System.out.println("下机");
        }
        System.out.println("回家");
        System.out.println("-------------------------------");
    }

    //if-else
    public static void if2() {
        //判断奇偶
        int num = 13;

        if (num % 2 == 0) {                 //如果除以2余数为0，说明是偶数
            System.out.println("even");
        } else {
            System.out.println("odd");      //奇数
        }

        System.out.println("-------------------------------");
    }

    //if - else if... - else
    public static void if3() {
        int x = 10;
        int y;

        if (x >= 3) {
            y = 2 * x + 1;
        } else if (-1 < x && x < 3) {
            y = 2 * x;
        } else {
            y = 2 * x - 1;
        }
        System.out.println("result: " + y);

        System.out.println("-------------------------------");
    }

    //使用三元运算符和标准的if-else语句分别实现：取两个数字当中的最大值
    public static void max() {
        int a = 10;
        int b = 20;

        //首先使用三元运算符
        int max1 = a > b ? a : b;
        System.out.println("Max: " + max1);

        //使用今天的if语句
        int max2 = 0;
        if (a > b) {
            max2 = a;
        } else {
            max2 = b;
        }
        System.out.println("Max: " + max2);
    }
}
