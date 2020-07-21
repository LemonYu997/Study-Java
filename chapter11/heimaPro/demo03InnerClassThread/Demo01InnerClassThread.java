//匿名内部类方式实现线程的创建
package chapter11.heimaPro.demo03InnerClassThread;

/*
 * 匿名内部类实现线程的创建
 *
 * 匿名：没有名字
 * 内部类：写在其他类内部的类
 *
 * 匿名内部类作用：简化代码
 *      把子类继承父类，重写父类的方法，创建子类对象合并为一步完成
 *      把实现类实现类接口，重写接口中的方法，创建实现类对象合成一步完成
 *
 * 匿名内部类的最终产物：
 *      子类/实现类对象，而这个类没有名字
 *
 * 格式：
 *      new 父类/接口() {
 *          重写父类/接口中的方法
 *      };
 * */
public class Demo01InnerClassThread {
    public static void main(String[] args) {
        //线程的父类是Thread
        // new MyThread().start();      //以前的方法
        //匿名内部类方法
        new Thread() {
            //重写run方法，设置线程任务
            @Override    
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + "苍蓝星" + i);
                }
            }
        }.start();      //开启多线程

        //线程的接口Runnable
        //Runnable r = new RunnableImpl();      //以前的方式，多态
        //匿名内部类方法
        Runnable r = new Runnable() {
            //重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + "咩咩子" + i);
                }
            }
        };
        new Thread(r).start();

        //简化接口的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + "雷娘" + i);
                }
            }
        }).start();
    }
}
