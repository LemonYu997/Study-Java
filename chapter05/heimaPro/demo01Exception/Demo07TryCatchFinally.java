//finally代码块
package chapter05.heimaPro.demo01Exception;

import java.io.IOException;

/*
 * finally：有一些特定的代码无论异常是否发生，都需要执行。另外，由于异常会引发程序跳转，导致有些语句执行不到。
 * 放在finally中的代码都是一定会被执行的
 *
 * finally代码块，同try...catch一同使用
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
 *      } finally {
 *          无论是否出现异常，都会执行
 *      }
 *
 * 注意事项：
 * 1、finally不能单独使用，必须和try一起使用
 * 2、finally一般用于资源释放(资源回收)，无论程序是否出现异常，最后都要资源释放(IO)
 * 3、
 *
 * */
public class Demo07TryCatchFinally {
    public static void main(String[] args) {
        try {
            //可能会产生异常的代码
            readFile("c:\\a.ttxt");
        } catch (IOException e) {
            //异常的处理逻辑
            e.printStackTrace();
        } finally {
            //无论是否出现异常，都会执行
            System.out.println("资源释放");
        }

//        java.io.IOException: 文件的后缀名不对
//            at chapter05.heimaPro.demo01Exception.Demo07TryCatchFinally.readFile(Demo07TryCatchFinally.java:55)
//            at chapter05.heimaPro.demo01Exception.Demo07TryCatchFinally.main(Demo07TryCatchFinally.java:36)
//        资源释放
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
