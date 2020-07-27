//字符输出流的续写和换行
package chapter12.heimaPro.demo05ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 续写和换行
 * 续写/追加写：使用两个参数的构造方法：
 * public FileWriter(File file, boolean append) throws IOException 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象
 * public FileWriter(String fileName, boolean append) throws IOException 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象
 * 参数：
 *      String fileName, File file：写入数据的目的地
 *      boolean append：
 *          true：创建对象不会覆盖原文件，继续在文件的末尾加写数据
 *          false：创建一个新文件，覆盖源文件
 * 换行：换行符号
 *      windows：\r\n
 *      linux：/n
 *      mac：/r
 * */
public class Demo05Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo05ReaderWriter\\www.txt", true);
        for (int i = 0; i < 20; i++) {
            fw.write("HelloWorld" + i + "\r\n");
        }
        fw.close();
    }
}
