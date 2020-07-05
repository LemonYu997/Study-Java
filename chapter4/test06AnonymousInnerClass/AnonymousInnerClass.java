//4.6 匿名内部类
package chapter4.test06AnonymousInnerClass;

/* 说明：
 * 当只需要创建一个类的对象时，可以不必命名，使用
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 把上个定时器程序用匿名内部类重构
 * @author mly
 * */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

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
    /**
     * 开始，使用匿名内部类
     * @param interval 打印时间的间隔
     * @param beep 闹钟响了说明成功
     * */
    public void start(int interval, boolean beep)
    {
        //匿名内部类，使用方法如下，在需要创建对象的地方直接添加方法
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
