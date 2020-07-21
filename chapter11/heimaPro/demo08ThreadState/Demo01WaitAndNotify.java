package chapter11.heimaPro.demo08ThreadState;

/*
 * 线程间通信：多个线程在处理同一个资源，但是处理的动作(线程的任务)却不相同
 * 例如：线程A吃包子，线程B做包子，包子是同一资源，线程A和线程B处理动作不同，之间存在线程通信问题
 *
 * 为什么要处理线程间通信：
 * 多线程并发执行时，默认情况下CPU是随机切换线程的，当需要多个线程共同完成一个任务并且有规律执行时，线程之间需要通信。
 *
 * 如何保证线程通信有效利用资源：等待唤醒机制
 *
 * 等待唤醒案例：线程之间的通信
 *      创建一个顾客线程(消费者)：告知老板要的种类和数量，调用wait()方法，放弃CPU的执行，进入到WAITING状态(无限等待)
 *      创建一个老板线程(生产者)：花了5秒做包子，做好包子后，调用notify()方法，唤醒顾客吃包子
 *
 * 注意：
 *      顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
 *      同步使用的锁对象必须保证唯一，只有锁对象才能调用wait和notify方法
 *
 * Object类中的方法：
 * void wait()：
 *      在其他线程调用此对象的notify()方法或notifyAll()方法前，导致当前线程等待
 * void notify()：
 *      唤醒在此对象监视器上等待的单个线程，会继续执行wait方法之后的代码
 *
 * 注意事项：
 * 1、wait方法和notify方法必须由同一个锁对象调用。
 *    因为：对应的锁对象可以通过notify唤醒使用同一个锁对象调用的wait方法后的线程
 * 2、wait方法和notify方法是属于Object类的方法
 *    因为：锁对象可以是任意对象，而任意对象的所属类都是继承了Object类的
 * 3、wait方法和notify方法必须要在同步代码块或者同步函数中使用
 *    因为，必须要通过锁对象调用这两个方法
 * */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj = new Object();

        //创建一个顾客线程(消费者)
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
                        System.out.println("真香");
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
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
