//Lambda表达式
package chapter11.heimaPro.demo10Lambda;

/*
 * 匿名内部类与lambda表达式的比较
 *
 * 匿名内部类的好处与弊端：
 * 匿名内部类可以省去实现类的定义，但是语法太复杂
 *
 * public abstract void run();
 * 这个方法：
 *      无参数：不需要任何条件即可执行
 *      无返回值：不产生任何结果
 *      代码块(方法体)：具体执行步骤
 *
 * 用lambda表达式执行这一方法：
 * ()->System.out.println("OK");
 * () 表示run方法的参数(无)
 * -> 表示将前面的参数传递给后面的代码
 * 后面的输出语句即代码块内容
 *
 *
 * Lambda表达式的标准格式：
 * 由三部分组成：
 *      1、一些参数
 *      2、一个箭头
 *      3、一段代码
 * 格式：
 *      (参数列表) -> {一些重写方法的代码}
 * 解释说明：
 *      ()：接口中抽象方法的参数列表，没有参数就空着，有参数就写参数，多个参数使用逗号分隔
 *      ->：传递的意思，把参数传递给方法体 {}
 *      {}：重写接口的抽象方法的方法体
 * */
public class Demo02Lambda {
    public static void main(String[] args) {
        //使用匿名内部类方式，实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程创建了");
            }
        }).start();

        //使用lambda表达式，实现多线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "新线程创建了");
        }).start();

        /*
         * 把()-> {System.out.println(Thread.currentThread().getName() + "新线程创建了");}当作参数
         * 放入 new Thread()的括号中，然后再执行start方法
         */

        //去掉大括号，更简洁但是不易读
        new Thread(()-> System.out.println(Thread.currentThread().getName() + "新线程创建了")).start();

    }


}
