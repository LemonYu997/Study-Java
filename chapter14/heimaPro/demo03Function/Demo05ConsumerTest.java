//Consumer接口中的默认方法andThen 练习
package chapter14.heimaPro.demo03Function;

import java.util.function.Consumer;

/*
 * 练习：格式化打印信息
 * 将字符串数组中的信息，按照格式"姓名：xx，性别：xx"的格式将信息打印出来，
 * 要求将打印姓名的动作作为第一个Consumer接口的Lambda实例
 * 将打印性别的动作作为第二个Consumer接口的Lambda实例
 * 将两个Consumer接口按照顺序"拼接"到一起
 * */
public class Demo05ConsumerTest {
    //定义一个方法，参数传递String类型的数组和两个Consumer接口，泛型使用String
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        //遍历字符串数组
        for (String message : arr) {
            //使用andThen方法连接两个Consumer接口，消费字符串
            con1.andThen(con2).accept(message);
        }
    }

    public static void main(String[] args) {
        //定义一个字符串类型的数组
        String[] arr = {"苍蓝星,女", "咩咩子,龙", "雷娘,龙"};

        //调用printInfo方法，传递一个字符串数组，和两个Lambda表达式
        printInfo(arr,
                (message)->{
                    //消费方式：对messgae进行切割，获取姓名，按照指定的格式输出
                    String name = message.split(",")[0];
                    System.out.print("姓名：" + name);
                },
                (message)->{
                    //消费方式：对message进行切割，获取性别，按照指定的格式输出
                    String sex = message.split(",")[1];
                    System.out.print("， 性别：" + sex + "。");
                });
    }
}
