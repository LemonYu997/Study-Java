//try...catch捕获异常
package chapter05.heimaPro.demo01Exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * try...catch：异常处理的第二种方式，自己处理异常
 *
 * 格式：
 *      try {
 *          可能产生异常的代码
 *      } catch(定义一个异常的变量，用来接收try抛出的异常) {
 *          异常的处理逻辑，出现异常对象之后，怎么处理异常对象
 *          一般在工作中，会把异常的信息记录到一个日志中
 *      }
 *      ...
 *      catch(异常类名 变量名) {
 *          ...
 *      }
 *
 * 注意事项：
 * 1、try中可能会抛出多个异常对象，那么就可以使用多个catch处理这些异常对象
 * 2、如果try中产生了异常，那么就会执行catch中的异常处理逻辑，执行完毕catch中的处理逻辑，继续执行try...catch之后的代码
 *    如果try中没有产生异常，那么不会执行catch中的异常处理逻辑，执行完try中的代码，继续执行try...catch之后的代码
 *
 * Throwable类中定义了3个异常处理的方法：
 * public String getMessage() 返回此 throwable 的详细消息字符串
 * public String toString() 返回此 throwable 的简短描述
 * public void printStackTrace(PrintStream s) 将此 throwable 及其追踪输出到指定的输出流
 *      JVN打印异常对象，默认调用此方法，打印的异常信息是最全面的
 * */
public class Demo06TryCatch {
    public static void main(String[] args) {
        //使用try...catch处理异常
        try {
            readFile("c:\\a.tx");
            System.out.println("资源释放");     //由于异常，执行不到此行代码
        } catch (IOException e) {       //try中抛出什么异常对象，catch就定义什么异常变量用来接收异常对象
            // 异常的处理逻辑，出现异常对象之后，怎么处理异常对象
//            System.out.println("catch - 传递的文件后缀不是 .txt ");

            /*
             * Throwable类中定义了3个异常处理的方法：
             * public String getMessage() 返回此 throwable 的详细消息字符串
             * public String toString() 返回此 throwable 的简短描述
             * public void printStackTrace(PrintStream s) 将此 throwable 及其追踪输出到指定的输出流
             *      JVN打印异常对象，默认调用此方法，打印的异常信息是最全面的
             * */
            System.out.println(e.getMessage());     //文件的后缀名不对
            System.out.println(e.toString());       //java.io.IOException: 文件的后缀名不对  重写Object的toString方法
            System.out.println(e);                  //java.io.IOException: 文件的后缀名不对
            e.printStackTrace();

        }

        System.out.println("后续代码");

//        catch - 传递的文件后缀不是 .txt
//        后续代码
//        java.io.IOException: 文件的后缀名不对
//            at chapter05.heimaPro.demo01Exception.Demo06TryCatch.readFile(Demo06TryCatch.java:69)
//            at chapter05.heimaPro.demo01Exception.Demo06TryCatch.main(Demo06TryCatch.java:37)
    }

    /*
     * 如果传递的路径，不是.txt结尾
     * 那么抛出IO异常对象，告知方法的调用者，文件的后缀名不对
     * */
    public static void readFile(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件的后缀名不对");
        }
    }
}
