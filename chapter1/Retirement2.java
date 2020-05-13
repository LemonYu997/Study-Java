//1.4 do while循环
package chapter1;

import java.util.Scanner;

//do while循环学习
public class Retirement2 {
    public static void main(String[] args) {
        //读取输入
        Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;         //余额
        int years = 0;

        String input;

        //更新帐户余额，当用户不准备退休时
        do {
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;

            //打印当前余额
            System.out.printf("After year %d, your balance is %,.2f%n", years, balance);
            //%,.2f%n  中的 "," 指输出结果用","分开，例如 3,333,333      %n表示换行

            //询问是否准备退休并得到输入结果
            System.out.print("Ready to retire?(Y/N) ");
            input = in.next();
        } while (input.equals("N"));
    }
}
