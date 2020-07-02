//8.1 GUI设计，Swing，JFrame
package chapter8.simpleFrame;

/* 说明：
 * JFrame、JButton等等JXXX类是Swing组件类，如果没有J，是AWT组件
 * 下边的程序介绍Swing的JFrame常用方法，在屏幕中显示一个空框架。
 * */

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @author mly
 * */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}