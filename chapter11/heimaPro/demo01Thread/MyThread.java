//创建多线程的方式
package chapter11.heimaPro.demo01Thread;

//1、创建一个Thread类的子类
public class MyThread extends Thread {
    //2、在Thread类的子类中重写Thread类中的run方法，设置线程任务(开启线程要做什么)
    @Override
    public void run() {
        //获取线程名称
        //1、使用Thread类中的方法getName()
        String name = getName();
        System.out.println(name);       //Thread-0 ...
        System.out.println("-------");

        //2、可以先获取到当前正在执行的线程，使用线程中的方法getName()获取线程的名称
        Thread t = Thread.currentThread();
        System.out.println(t);          //Thread[Thread-0,5,main]

        //链式编程
        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 20; i++) {
            System.out.println("run: " + i);
        }
    }

    public MyThread() {

    }

    public MyThread(String name) {
        super(name);
    }
}
