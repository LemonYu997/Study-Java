package chapter11.heimaPro.demo09ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 线程池：其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁的创建线程对象的操作，
 * 无需反复创建线程而消耗过多的资源，JDK1.5+。
 *
 * java.util.concurrent.Executors 线程池的工厂类，用来生产线程池
 *
 * 常用方法：
 * public static ExecutorService newFixedThreadPool(int nThreads)
 * 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程
 * 参数：
 *      int nThreads - 池中的线程数
 * 返回：
 *      ExecutorService接口，返回的是ExecutorService接口的实现类对象，可以使用ExecutorService接口接收(面向接口编程)
 *      新创建的线程池
 * 抛出：
 *      IllegalArgumentException - 如果 nThreads <= 0
 *
 *
 * java.util.concurrent.ExecutorService 线程池接口
 * 常用方法：
 * 1、用来从线程池获取线程，调用start方法，执行线程任务
 *      Future<?> submit(Runnable task)
 * 2、关闭/销毁线程池的方法
 *      void shutdown()
 *
 *
 * 线程池的使用步骤：
 * 1、使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
 * 2、创建一个类，实现Runnable接口，重写run方法，设置线程任务
 * 3、调用ExecutorService中的方法submit，传递线程任务(实现类)，开启线程，执行run方法
 * 4、调用ExecutorService中的方法shutdown销毁线程(不建议执行)
 * */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1、使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3、调用ExecutorService中的方法submit，传递线程任务(实现类)，开启线程，执行run方法
        es.submit(new RunnableImpl());      //pool-1-thread-1创建了一个新的线程执行
        //线程池会一直开启，使用完了线程，会自动把线程归还给线程池，线程可以继续使用
        es.submit(new RunnableImpl());      //pool-1-thread-2创建了一个新的线程执行
        es.submit(new RunnableImpl());      //pool-1-thread-1创建了一个新的线程执行

        //4、调用ExecutorService中的方法shutdown销毁线程(不建议执行)
        es.shutdown();

        //线程池已经销毁，再调用线程，无法获取线程，会抛出异常
        es.submit(new RunnableImpl());      //RejectedExecutionException异常
    }
}
