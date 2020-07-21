package chapter11.heimaPro.demo08ThreadState;

/*
 * 进入了到TimeWaiting(计时等待)有两种方式：
 * 1、使用sleep(long m)方法，在毫秒值结束之后，线程睡醒进入到Runnable/Blocked状态
 * 2、使用wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来，线程睡醒进入到Runnable/Blocked状态
 *
 * 唤醒的方法：
 * void notify() 唤醒在此对象监视器上等待的单个线程
 * void notifyAll() 唤醒在此对象监视器上等待的所有线程
 * */
public class Demo02WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj = new Object();

        //创建一个顾客1线程(消费者)
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("老板，我要大肉包");
                        //调用wait方法，放弃CPU的执行，进入到WAITING状态(无限等待)
                        try {
//                            obj.wait(5000);
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("真香，是我1的了");
                        System.out.println("----------------------------");
                    }
                }
            }
        }.start();

        //创建一个顾客2线程(消费者)
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("老板，我要大肉包");
                        //调用wait方法，放弃CPU的执行，进入到WAITING状态(无限等待)
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("真香，是我2的了");
                        System.out.println("----------------------------");
                    }
                }
            }
        }.start();

        //创建一个老板线程(生产者)
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //花5秒做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("在做了，在做了");
                        //做好包子后，调用notify()方法，唤醒顾客吃包子
                        obj.notifyAll();        //唤醒所有线程
                    }
                }
            }
        }.start();
    }
}
