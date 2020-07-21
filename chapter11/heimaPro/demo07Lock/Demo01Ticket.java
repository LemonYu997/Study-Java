//线程安全问题
package chapter11.heimaPro.demo07Lock;

/*
 * 模拟卖票案例
 * 创建3个线程，同时开启，对共享的票进行出售
 *
 * 卖票案例出现了线程安全问题：卖出了不存的在票和重复的票
 *
 * 解决线程安全问题的第三种方案：使用Lock锁
 *
 * java.util.concurrent.locks.Lock接口
 * Lock实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作
 *
 * Lock接口中的方法：
 *      void lock() 获取锁
 *      void unlock() 释放锁
 * java.util.concurrent.locks.ReentrantLock implements Lock接口
 * 一个可重入的互斥锁 Lock，它具有与使用 synchronized 方法和语句所访问的隐式监视器锁相同的一些基本行为和语义，但功能更强大。
 *
 * 使用步骤：
 * 1、在成员位置创建一个ReentrantLock对象
 * 2、在可能会出现安全问题的代码前调用Lock接口中的方法lock()获取锁
 * 3、在可能会出现安全问题的代码后调用Lock接口中的方法unlock()释放锁
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        //创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }

}
