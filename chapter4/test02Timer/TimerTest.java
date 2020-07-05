//4.2 接口与回调
//回调 是一种常见的程序设计模式，在这种模式中，可以指出某个特定事件发生时应该采取的动作。
package chapter4.test02Timer;

import javax.swing.*;
//swing中有一个timer，util中也有一个timer，为了防止冲突，这里导包要设置好
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 每隔10秒打印一条信息并响一下
 * @author mly
 * */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();    //接口的实现类对象

        //构造一个调用监听器的定时器
        //每隔10秒
        Timer t = new Timer(10000, listener);
        //timer构造器，第一个参数是发出通告的时间间隔，第二个参数是监听器对象
        t.start();      //启动定时器
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

//实现ActionListener接口中的acntionPerformed方法
class TimePrinter implements ActionListener
{
    //ActionEvent event提供了事件产生的相关信息
    public void actionPerformed(ActionEvent event) {
        //打印如下信息
        System.out.println("At the tone, the time is " + new Date());
        //响一下
        Toolkit.getDefaultToolkit().beep();
    }
}
