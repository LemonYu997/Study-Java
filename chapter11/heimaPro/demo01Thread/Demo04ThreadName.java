//Thread类的常用方法————getName() setName(名字)
package chapter11.heimaPro.demo01Thread;

/*
 * Thread类的常用方法
 *
 * 获取线程的名称：
 * 1、使用Thread类中的方法getName()
 *      public final String getName() 返回该线程的名称
 * 2、可以先获取到当前正在执行的线程，使用线程中的方法getName()获取线程的名称
 *      public static Thread currentThread() 返回对当前正在执行的线程对象的引用
 *
 * 线程的名称：
 *      主线程：main
 *      新线程：Thread-0, Thread-1, Thread-2...
 *
 * 设置线程的名称：(了解)
 * 1、使用Thread类中的方法setName(名字)
 *      public final void setName(String name) 改变线程名称，使之与参数 name 相同
 * 2、创建一个带参数的构造方法，参数传递线程的名称；调用父类的带参构造方法，把线程名称传递给父类，让父类(Thread)给子线程起一个名字
 *      public Thread(String name) 分配新的 Thread 对象
 * */
//定义一个Thread类的子类
public class Demo04ThreadName {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread mt = new MyThread();
        //调用start方法，开启新线程，执行run方法

        //给线程起名
        //1、使用Thread类中的方法setName(名字)
        mt.setName("苍蓝星");
        mt.start();

        //2、创建一个带参数的构造方法，参数传递线程的名称；调用父类的带参构造方法，把线程名称传递给父类，让父类(Thread)给子线程起一个名字
        new MyThread("咩咩子").start();

        //获取主线程名称
        System.out.println(Thread.currentThread().getName());       //main
    }
}
