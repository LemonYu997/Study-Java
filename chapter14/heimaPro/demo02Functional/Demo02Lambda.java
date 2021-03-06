//使用Lambda优化日志案例
package chapter14.heimaPro.demo02Functional;

/*
 * 使用Lambda优化日志案例
 * Lambda的特点：延迟加载
 * Lambda的使用前提，必须存在函数式接口
 * */
public class Demo02Lambda {
    //定义一个显示日志的方法，方法的参数传递日志的等级和MessageBuilder接口
    public static void showLog(int level, MessageBuilder mb) {
        //对日志的等级进行判断，如果是1级，则调用MessageBuilder接口中的builderMessage放啊
        if (level == 1) {
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";

        //调用showLog方法，参数MessageBuilder是一个函数式接口，所以可以传递Lambda表达式
        showLog(2, ()->{
            System.out.println("不满足条件不执行");
            //返回一个拼接好的字符串
            return msgA + msgB + msgC;
        });

        /*
         * 使用Lambda表达式作为参数传递，仅仅是把参数传递到showLog方法中
         * 只有满足条件，日志的等级是1级，才会调用接口MessageBuilder中的方法builderMessage，才会进行字符串的拼接
         * 如果条件不满足，日志的等级不是1级，那么MessageBuilder接口中的方法builderMessage也不会执行
         * 所以拼接字符串的代码也不会执行，不会存在性能的浪费
         * */
    }
}
