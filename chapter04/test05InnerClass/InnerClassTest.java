//4.5 内部类
package chapter04.test05InnerClass;

/* 使用内部类的作用：
 * 1、内部类方法可以访问该类定义所在的作用域中的数据，包括私有的数据。
 * 2、内部类可以对同一个包中的其他类隐藏起来。
 * 3、当想要定义一个回调函数且不想编写大量代码时，使用匿名内部类比较便捷。
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 使用内部类访问对象，举例：定时器
 * @author mly
 * */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        //用户确认是否退出
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * 按一定间隔打印时间的钟
 * */
class TalkingClock
{
    private int interval;
    private boolean beep;

    /**
     * 构造器
     * @param interval 打印时间的间隔
     * @param beep 闹钟响了说明成功
     * */
    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * 开始
     * */
    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    //内部类
    public class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("At the tone, the time is " + new Date());
            //可以访问外部域
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
}