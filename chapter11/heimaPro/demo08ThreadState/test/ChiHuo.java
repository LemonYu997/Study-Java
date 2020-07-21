package chapter11.heimaPro.demo08ThreadState.test;

/*
 * 消费者(吃货)类：是一个线程类，可以继承Thread
 * 设置线程任务(run)：吃包子
 *
 * 对包子的状态进行判断：
 * false：没有包子
 *      吃货调用wait方法进入等待状态
 * true：有包子
 *      吃货吃包子
 *      吃完包子，修改包子的状态为false没有
 *      吃货唤醒包子铺线程，生产包子
 * */
public class ChiHuo extends Thread {
    //1、需要在成员位置创建一个包子变量
    private BaoZi bz;

    //2、使用带参数构造方法，为这个包子变脸赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    //设置线程任务(run)：吃包子
    @Override
    public void run() {
        //让吃货一直吃包子
        while (true) {
            //必须使用同步技术保证两个线程只能有一个在执行
            //锁对象必须保证唯一，可以使用包子对象作为锁对象
            synchronized (bz) {
                //对包子的状态进行判断：
                if (bz.flag == false) {       //false ：没有包子
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后执行的代码，吃包子
                System.out.println("吃货正在吃：" + bz.pi + bz.xian + "包子");
                // 吃完包子，修改包子的状态为false没有
                bz.flag = false;
                //吃货唤醒包子铺线程，生产包子
                bz.notify();
                System.out.println("吃完了，真香！下一个！");
                System.out.println("---------------------------------------");
            }
        }
    }
}
