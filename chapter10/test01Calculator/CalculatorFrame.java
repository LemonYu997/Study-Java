package chapter10.test01Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Frame frame = new Frame();
            frame.setTitle("CalculatorTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class Frame extends JFrame {
    //创建面板对象
    CalculatorPanel panel = new CalculatorPanel();
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public Frame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //添加面板
        add(panel);
        //调整为适当大小
        pack();
    }
}