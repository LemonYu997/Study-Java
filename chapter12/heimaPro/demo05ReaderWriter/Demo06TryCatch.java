package chapter12.heimaPro.demo05ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 在jdk1.7之前使用try catch finally 处理流中的异常
 * 格式：
 *      try {
 *          可能会产出异常的代码
 *      } catch(异常类变量 变量名) {
 *          异常的处理逻辑
 *      } finally {
 *          一定会执行的代码，资源释放
 *      }
 *
 * */
public class Demo06TryCatch {
    public static void main(String[] args) {
        //提高变量fw的作用域，让finally可以使用
        //变量在定义的时候，可以没有值，但是使用时必须有值
        //fw = new FileWriter("...", true);执行失败，fw没有值，fw.close会报错
        FileWriter fw = null;       //进行初始化

        try {
            //可能会产出异常的代码
            fw = new FileWriter("F:\\Java\\Project\\Study\\src\\chapter12\\heimaPro\\demo05ReaderWriter\\www.txt", true);
            for (int i = 0; i < 20; i++) {
                fw.write("HelloWorld" + i + "\r\n");
            }
        } catch (IOException e) {
            //异常的处理逻辑
            System.out.println(e);
        } finally {
            //一定会执行的代码，资源释放
            //如果创建对象失败了，fw默认值是null，null是不能调用方法得，会抛出NullPointerException，需要增加一个判断不是空，再把资源释放
            if (fw != null) {
                try {
                    //fw.close声明抛出了IOException异常对象，所以就要处理这个异常对象，要么throws，要么trycatch
                    fw.close();         //本身有异常
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
