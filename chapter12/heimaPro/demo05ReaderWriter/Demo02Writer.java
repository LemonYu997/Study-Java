//字符输出流 Writer类
package chapter12.heimaPro.demo05ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
 * java.io.Writer：字符输出流，是所有字符输出流的最顶层的父类，是一个抽象类
 *
 * 共性的成员方法：
 * void write(int c)：写入单个字符
 * void write(char[] cbuf)：写入字符数组
 * void write(char[] cbuf, int off, int len)：写入字符数组的某一部分，off数组的开始索引，len写的字符个数
 * void write(String str)：写入字符串
 * void write(String str, int off, int len)：写入字符串的某一部分，off字符串的开始索引，len写的字符个数
 * void flush()：刷新该流的缓冲
 * void close()：关闭此流，但要先刷新它
 *
 * 子类：FileWriter，文件字符输出流
 * java.io.FileWriter extends OutputStreamWriter extends Writer
 * 作用：把内存中字符数据写入到文件中
 *
 * 构造方法：
 * public FileWriter(File file) throws IOException 根据给定的 File 对象构造一个 FileWriter 对象
 * public FileWriter(String fileName) throws IOException 根据给定的文件名构造一个 FileWriter 对象
 * 参数：写入数据的目的地
 *      String fileName：文件的路径
 *      File file：一个文件
 * 构造方法的作用：
 * 1、创建一个FileWriter对象
 * 2、根据构造方法中传递的文件/文件的路径，创建文件
 * 3、把FileWriter对象指向创建好的文件
 *
 * 字符输出流的使用步骤【重点】：
 * 1、创建FileWriter对象，构造方法中绑定要写入数据的目的地
 * 2、使用FileWriter中的方法writer，把数据写入到内存缓冲区中(字符转换为字节的过程)
 * 3、使用FileWriter中的方法flush，把内存缓冲区中的数据，刷新到文件中
 * 4、释放资源(会先把内存缓冲区中的数据刷新到文件中)
 * */
public class Demo02Writer {
    public static void main(String[] args) throws IOException {
        //1、创建FileWriter对象，构造方法中绑定要写入数据的目的地
        FileWriter fw = new FileWriter("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo05ReaderWriter\\www.txt");
        //2、使用FileWriter中的方法writer，把数据写入到内存缓冲区中(字符转换为字节的过程)
        //void write(int c)：写入单个字符
        fw.write(98);

        //3、使用FileWriter中的方法flush，把内存缓冲区中的数据，刷新到文件中
//        fw.flush();       close方法能够将内存中的数据刷新到文件中

        //4、释放资源(会先把内存缓冲区中的数据刷新到文件中)
        fw.close();
    }
}
