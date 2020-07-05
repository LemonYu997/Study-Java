//1.2 输入输出
package chapter1;

//Scanner类定义在java.util包中，使用的类不是定义在基本java.lang包中，要用import指示字将相应的包加载进来
import java.util.Scanner;

public class Test02InputTest {
    public static void main(String[] args) {
        //构建一个Scanner对象，与"标准输入流"System.in关联
        //额可以用Scanner类从键盘接收对象，用next方式接收字符串
        Scanner in =  new Scanner(System.in);

        //得到第一个输入
        System.out.println("What's your name?");
        String name = in.nextLine();                //用nextline()是读取一行输入，用next()是读取一个单词输入

        //得到第二个输入
        System.out.println("How old are you?");
        int age = in.nextInt();                     //读取一个整数

        //显示输入结果
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
        System.out.printf("Hello, %s. Next year, you'll be %d\n", name, age + 1);

        //使用静态的String.format方法创建一个格式化字符串，并不打印输出
        String message = String.format("Hello, %s. Next year, you'll be %d\n", name, age + 1);
        System.out.println(message);                //打印输出刚刚创建的格式化字符串
    }
}

/*
*   System.out.print();             是一般输出，不换行
*   System.out.println();           是换行输出
*   System.out.printf("8.2f", x);   和C语言中的printf()一样，可以转换格式，也可以使用多个参数进行输出
*/
