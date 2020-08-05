//打印流
package chapter12.heimaPro.demo11PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 * 可以改变输出语句的目的地(打印流的流向)
 * 输出语句，默认在控制台输出
 * 使用System.setOut方法改变输出语句的目的地改为参数传递的打印流的目的地：
 *      static void setOut(PrintStream out) 重新分配"标准"输出流
 *
 * */
public class Demo02PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("在控制台输出");

        PrintStream ps = new PrintStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo11PrintStream\\打印流.txt");
        System.setOut(ps);      //把输出语句的目的地改变为打印流的目的地
        System.out.println("我在打印流的目的地中输出");

        ps.close();
    }
}
