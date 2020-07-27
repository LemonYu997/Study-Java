package chapter12.heimaPro.demo05ReaderWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * JDK9+新特性
 * try的前边可以定义流对象，在try后边的()中可以直接引入流对象的名称(变量名)
 * 在try代码执行完毕之后，流对象也可以释放掉，不用谢finally
 * 格式：
 *      A a = new A();
 *      B b = new B();
 *       try(a, b) {
 *          可能会产出异常的代码
 *      } catch(异常类变量 变量名) {
 *          异常的处理逻辑
 *      }
 * */
public class Demo08JDK9 {
    public static void main(String[] args) {
        //JDK9写法，由于JDK不支持，先注释掉

//        //1、创建一个字节输入流对象，构造方法中绑定要读取的数据源
//        FileInputStream fis = new FileInputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo04IO\\test.jpg");
//        //2、创建一个字节输出流对象，构造方法中绑定要写入的目的地
//        FileOutputStream fos = new FileOutputStream("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo03Filter\\test.jpg")
//
//        try (fis; fos) {
//            //使用数组缓冲读取多个字节，写入多个字节
//            byte[] bytes = new byte[1024 * 10];
//            //3、使用字节输入流对象中的方法read读取文件
//            int len = 0;        //每次读取的有效字节的个数
//            while ((len = fis.read(bytes)) != -1) {
//                //4、使用字节输出流中的方法write，把读取到的字节写入到目的地文件中
//                fos.write(bytes, 0, len);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }
}
