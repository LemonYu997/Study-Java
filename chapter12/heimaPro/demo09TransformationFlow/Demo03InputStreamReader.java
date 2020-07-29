//转换流 InputStreamReader
package chapter12.heimaPro.demo09TransformationFlow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * java.io.InputStreamReader extends Reader
 * InputStreamReader：是字节流通向字符流的桥梁，它使用指定的charset读取字节并将其节码为字符（解码：把看不懂的变成能看懂的）
 *
 * 继承自父类的共性成员方法：
 * int read()：读取单个字符并返回
 * int read(char[] cbuf)：一次读取多个字符，将字符读入数组
 * void close()：关闭该流并释放与之管理的所有资源
 *
 * 构造方法：
 * public InputStreamReader(InputStream in)创建一个使用默认字符集的 InputStreamReader
 * public InputStreamReader(InputStream in, String charsetName) throws UnsupportedEncodingException创建使用指定字符集的 InputStreamReader
 * 参数：
 *      InputStream in：字节输入流，用来读取文件中保存的字节
 *      String charsetName：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8，gbk/GBK...不指定默认使用UTF-8
 *
 * 使用步骤：
 * 1、创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
 * 2、使用InputStreamReader对象中的方法read读取文件
 * 3、释放资源
 * 注意事项：
 * 构造方法中指定的编码表名称要和文件的编码相同，否则会发生乱码
 * */
public class Demo03InputStreamReader {
    public static void main(String[] args) throws IOException {
        read_utf_8();
        read_gbk();
    }

    /*
     * 使用InputStreamReader读取UTF-8格式的文件
     * */
    private static void read_utf_8() throws IOException {
        //1、创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo09TransformationFlow\\utf_8_test.txt"), "utf-8");
        //不指定 默认用utf-8
        InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo09TransformationFlow\\utf_8_test.txt"));
        //2、使用InputStreamReader对象中的方法read读取文件
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.println((char)len);
        }
        //3、释放资源
        isr.close();
    }

    /*
     * 使用InputStreamReader读取GBK格式的文件
     * */
    private static void read_gbk() throws IOException {
        //1、创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称
        InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo09TransformationFlow\\gbk_test.txt"), "GBK");
        //2、使用InputStreamReader对象中的方法read读取文件
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.println((char)len);
    }
        //3、释放资源
        isr.close();
    }
}
