//1.3 while循环
package chapter01;

import java.util.Scanner;

//while循环学习
//计算多长时间才能存储一定数量的退休金
public class Test03Retirement {
    public static void main(String[] args) {

        //读取输入
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;         //余额
        int years = 0;

        //当余额没有达到目标时，更新帐户余额
        while (balance < goal)
        {
            //加上今年的退休金
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }

        System.out.println("You can retire in " + years + " years.");

    }
}
