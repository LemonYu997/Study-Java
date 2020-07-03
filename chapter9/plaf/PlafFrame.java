//9.2 改变观感
package chapter9.plaf;

import javax.swing.*;

/**
 * 包含改变观感按钮面板的框架
 * */
public class PlafFrame extends JFrame {
    private JPanel buttonPanel;

    public PlafFrame() {
        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(), info.getClassName());

        add(buttonPanel);
        pack();
    }

    /**
     * 创建一个按钮来改变观感
     * @param name 按钮名字
     * @param className 观感类的名字
     * */
    private void makeButton(String name, String className) {
        //在面板上添加一个按钮
        JButton button = new JButton(name);
        buttonPanel.add(button);

        //设置按钮动作
        button.addActionListener(event -> {
            //按钮动作：切换成新观感
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } );
    }
}
