//字节输入流，InputStream类
package chapter12.heimaPro.demo04IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * java.io.InputStream：字节输入流
 * 此抽象类是表示字节输入流的所有类的超类，定义了所有子类共性的方法
 *
 * 方法：
 * public abstract int read() throws IOException 从输入流中读取数据的下一个字节
 * public int read(byte[] b) throws IOException 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中
 * public void close() throws IOException 关闭此输入流并释放与该流关联的所有系统资源
 *
 * 子类：
 * java.io.FileInputStream extends InputStream
 * FileInputStream：文件字节输入流
 * 作用：把硬盘文件中的数据，读取到内存中使用
 *
 * 构造方法：
 * public FileInputStream(String name) throws FileNotFoundException
 * public FileInputStream(File file) throws FileNotFoundException
 * 参数：读取文件的数据源
 *      String name：文件的路径
 *      File file：文件
 * 构造方法的作用：
 * 1、会创建一个FileInputStream对象
 * 2、会把FileInputStream对象指定构造方法中要读取的文件
 *
 * 读取的数据的原理(硬盘-->内存)
 * java程序-->JVM-->OS-->OS读取数据的方法-->读取文件
 *
 * 字节输入流的使用步骤(重点)：
 * 1、创建一个FileInputStream对象，构造方法中绑定要读取的数据源
 * 2、使用FileInputStream对象中的方法read，读取文件
 * 3、释放资源
 * */
public class Demo04InputStream {
    public static void main(String[] args) throws IOException {
        //1、创建一个FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo04IO\\test2.txt");
        //2、使用FileInputStream对象中的方法read，读取文件
        //int read()读取文件中的一个字节并返回，读取到文件的末尾返回-1
//        int len = fis.read();
//        System.out.println(len);    //65 A
//
//        int len = fis.read();
//        System.out.println(len);    //66 B
//
//        int len = fis.read();
//        System.out.println(len);    //67 C

        /*
         * 读取文件是一个重复的过程，所以可以使用循环优化
         * 不知道文件中有多少字节，使用while循环
         * while循环结束条件，读取到-1的时候结束
         *
         * 布尔表达式(len = fis.read()) != -1
         * 1、fis.read()：读取一个字节
         * 2、len = fis.read()：把读取到的字节赋值给变量len
         * 3、(len = fis.read()) != -1：判断变量len是否不等于-1
         * */
        int len = 0;        //记录读取到的字节
        while ((len = fis.read()) != -1) {
            System.out.println(len);
        }

        //释放资源
        fis.close();
    }
}
