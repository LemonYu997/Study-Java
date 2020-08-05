//函数式编程————性能浪费的日志案例
package chapter14.heimaPro.demo02Functional;

/*
 * 日志案例
 *
 * 发现以下代码存在的一些性能浪费的问题
 * 调用showLog方法，传递的第二个参数是一个拼接好后的字符串
 * 先把字符串拼接好，然后再调用showLog方法
 * showLog方法中如果传递的日志等级不是1级，就会白拼接了字符串
 * */
public class Demo01Logger {
    //定义一个根据日志的级别，显示日志信息的放啊
    private static void showLog(int level, String msg) {
        //对日志的等级进行判断，如果是1级别，那么输出日志信息
        if (level == 1) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";

        //调用log方法，传递日志级别和日志信息
        showLog(1, msgA + msgB + msgC);
    }
}
