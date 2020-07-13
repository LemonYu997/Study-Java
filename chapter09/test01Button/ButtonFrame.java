//9.1 事件处理基础，按钮点击
package chapter09.test01Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 包含按钮面板的框架
 * */
public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //创建按钮
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        buttonPanel = new JPanel();

        //在面板上添加按钮
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        //在框架上添加面板
        add(buttonPanel);

        //创建按钮动作
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        //将动作和按钮联系起来
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    /**
     * 设置面板背景颜色的动作监听器
     * */
    private class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent event) {
            buttonPanel.setBackground(backgroundColor);
        }
    }


    //一个辅助方法，可以更简洁地指定监听器，用这个方法不用像上面一样创建一个专门的类
    public void make (String name, Color backgroundColor) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event->buttonPanel.setBackground(backgroundColor));
    }
}

