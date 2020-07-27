//字符输出流写数据的其他方法
package chapter12.heimaPro.demo05ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符输出流写数据的其他方法，一次写多个字符
 * void write(char[] cbuf)：写入字符数组
 * void write(char[] cbuf, int off, int len)：写入字符数组的某一部分，off数组的开始索引，len写的字符个数
 * void write(String str)：写入字符串
 * void write(String str, int off, int len)：写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 * */
public class Demo04Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo05ReaderWriter\\www.txt");
        char[] cs = {'a', 'b', 'c', 'd', 'e'};
        //void write(char[] cbuf)：写入字符数组
        fw.write(cs);       //abcde

        //void write(char[] cbuf, int off, int len)：写入字符数组的某一部分，off数组的开始索引，len写的字符个数
        fw.write(cs, 1, 3);     //abcdebcd

        //void write(String str)：写入字符串
        fw.write("苍蓝星");        //abcdebcd苍蓝星

        //void write(String str, int off, int len)：写入字符串的某一部分，off字符串的开始索引，len写的字符个数
        fw.write("打咩咩", 1, 2);        //abcdebcd苍蓝星咩咩

        fw.close();
    }
}
