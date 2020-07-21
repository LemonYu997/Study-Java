//冗余的Runnable代码
package chapter11.heimaPro.demo10Lambda;

/*
 * 面向对象的思想：
 *      做一件事情，找一个能解决这个事情的对象，调用对象的方法，完成事情
 * 函数式编程思想：
 *      只要能获取到结果，谁去做的，怎么做的不重要，重视的是结果，不重视过程
 *
 * 实现使用Runnable接口的方式实现多线程程序，冗余代码分析：
 * 1、Thread类需要Runnable接口作为参数，其中抽象run方法是用雷指定线程任务内容的核心
 * 2、为了指定run的方法体，需要Runnable接口的实现类
 * 3、为了省去定义一个RunnableImpl实现类的麻烦，要使用匿名内部类
 * 4、为了覆盖重写抽象run方法，方法名称、方法参数、方法返回值都要重写一遍，不能出错
 * 5、实际上，只有run方法体才是关键
 * */
public class Demo01Runnable {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        //创建Thread类对象，构造方法中传递Runnable接口的实现类
        Thread t = new Thread(run);
        //调用start方法开启新线程，执行run方法
        t.start();

        //简化代码，使用匿名内部类，实现多线程程序
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程创建了");
            }
        };
        new Thread(run2).start();

        //继续简化代码，匿名对象+匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程创建了");
            }
        }).start();
    }
}
