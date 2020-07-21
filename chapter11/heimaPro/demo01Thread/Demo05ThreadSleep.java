//Thread类的常用方法  sleep
package chapter11.heimaPro.demo01Thread;

/*
 * public static void sleep(long millis) throws InterruptedException
 * 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响
 * 毫秒数结束之后，程序继续执行
 *
 * */
public class Demo05ThreadSleep {
    public static void main(String[] args) {
        //模拟秒表
        for (int i = 1; i <= 60; i++) {
            System.out.println(i);

            //使用Thread类的sleep方法让程序睡眠1秒钟
            //让当前正在执行的线程休眠，即这里的main线程
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
