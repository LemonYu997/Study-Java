package chapter11.heimaPro.demo07Lock;

/*
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
 * */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//实现卖票案例
public class RunnableImpl implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;

    //1、在成员位置创建一个ReentrantLock对象
    Lock l = new ReentrantLock();

    //设置线程任务：卖票
    //优化代码，使用finally块
    @Override
    public void run() {
        //使用死循环，让卖票操作重复执行
        while (true) {
            //2、在可能会出现安全问题的代码前调用Lock接口中的方法lock()获取锁
            l.lock();

            //先判断票是否存在
            if (ticket > 0) {
                //提高安全问题出现的概率，让程序睡眠
                try {
                    Thread.sleep(10);
                    //票存在，卖票ticket--
                    System.out.println(Thread.currentThread().getName() + " --> 正在卖第" + ticket + "张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //3、在可能会出现安全问题的代码后调用Lock接口中的方法unlock()释放锁
                    l.unlock();     //无论是否程序出现异常，都会把锁释放
                }
            }
        }
    }

   /* //设置线程任务：卖票
    @Override
    public void run() {
        //使用死循环，让卖票操作重复执行
        while (true) {
            //2、在可能会出现安全问题的代码前调用Lock接口中的方法lock()获取锁
            l.lock();

            //先判断票是否存在
            if (ticket > 0) {
                //提高安全问题出现的概率，让程序睡眠
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
                //票存在，卖票ticket--
                System.out.println(Thread.currentThread().getName() + " --> 正在卖第" + ticket + "张票");
                ticket--;
            } else {
                break;
            }

            //3、在可能会出现安全问题的代码后调用Lock接口中的方法unlock()释放锁
            l.unlock();
        }
    }*/
}
