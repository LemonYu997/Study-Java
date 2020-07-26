//一次输入多个字节
package chapter12.heimaPro.demo04IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * 字节输入流一次输入读取多个字节的方法：
 *      int read(byte[] a) 从输入流中读取一定数量的字符，并将其存储在缓冲区数组b中
 * 明确两件事情：
 * 1、方法的参数byte[]的作用？
 *      缓冲作用，存储每次读到的多个字节
 *      数组的长度一般定义为1024(1kb)或者1024的整数倍
 * 2、方法的返回值int是什么？
 *      每次读取的有效字节个数
 *
 * String类的构造方法
 * String(byte[] bytes)：把字节数组转换为字符串
 * String(byte[] bytes, int offset, int length)：把字节数组的一部分转换为字符串 offset：数组的开始索引 length：转换的字节个数
 * */
public class Demo05InputStream {
    public static void main(String[] args) throws IOException {
        //1、创建一个FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo04IO\\test2.txt");
        //使用FileInputStream对象中的方法read读取文件
        //int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
//        byte[] bytes = new byte[2];
//        int len = fis.read(bytes);
//        System.out.println(len);        //2
//        //System.out.println(Arrays.toString(bytes));     //[65, 66]
//        System.out.println(new String(bytes));          //AB
//
//        len = fis.read(bytes);
//        System.out.println(len);        //2
////        System.out.println(Arrays.toString(bytes));     //[67, 68]
//        System.out.println(new String(bytes));          //CD
//
//        len = fis.read(bytes);
//        System.out.println(len);        //2
//        System.out.println(new String(bytes));          //EB

        /*
         * 以上读取是一个重复的过程，可以使用循环优化
         * 不知道文件中有多少字节，所以使用while循环
         * while循环结束的条件，读取到-1结束
         * */
        byte[] bytes = new byte[1024];      //存储读取到的多个字节
        int len = 0;        //记录每次读取的有效字节个数
        while((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes));
        }

        //释放资源
        fis.close();
    }
}
